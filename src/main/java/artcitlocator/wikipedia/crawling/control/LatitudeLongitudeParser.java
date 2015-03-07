package artcitlocator.wikipedia.crawling.control;

public class LatitudeLongitudeParser {
	
	
	/**
	 * Gibt Latitude und Longitude in dezimaler und auf N/E normalisierter Form zur�ck.
	 * @param Wikitext
	 * @return index=0 -> latitude / index=1 -> longitude / null -> Fehler, keine Koordinaten vorhanden
	 */
	public double[] parseLatLon(String text){
		double[] latlon = new double[2];
		double[] latDeg = new double[3];
		double[] lonDeg = new double[3];
		
		boolean success;
		
		text = text.toLowerCase();
		text = text.replaceAll("\\s", "");
		text = text.replaceAll("_", "");
	
		
		success = parseText(text, "|latitude=", latlon, 0) && parseText(text, "|longitude=", latlon, 1);
		success = success && (latlon[0] != 0.0 || latlon[1] != 0.0); //leere Tags abfangen, Wiki stinkt
		if(success) return latlon; // die Suche nach der ersten Variante war erfolgreich, negative stehen f�r s�d bzw west
						
		
		success = parseText(text, "|latd=", latDeg, 0) && parseText(text, "|longd=", lonDeg, 0);
		if(success){
			
			success = parseText(text, "|latm=", latDeg, 1) | parseText(text, "|longm=", lonDeg, 1);
			
			if(success){
				
				success = parseText(text, "|lats=", latDeg, 2) | parseText(text, "|longs=", lonDeg, 2);
			}
			
			
			//Umrechnung von Grad in Dezimal
			latlon[0] = latDeg[0]+(latDeg[1]*60.0+latDeg[2])/3600.0;
			latlon[1] = lonDeg[0]+(lonDeg[1]*60.0+lonDeg[2])/3600.0;
			
			normalize(latlon, text); // �berpr�fen ob �bergeben der Referenz langt!!
			
		} 
			
		
		//!success || 
		if((Math.abs(latlon[0]) < 0.000000001 && Math.abs(latlon[1]) < 0.000000001 )){
			// weder die Suche nach |latitude / |longitude noch |latd / longd war erfolgreich
			// suche nach der {{coord}} variante
			parseCoordTag(latlon, text); // �berpr�fen ob �bergabe genug ist
		} 		
		
		//Alte Tags, Wikipedia stinkt immer mehr..
		if((Math.abs(latlon[0]) < 0.000000001 && Math.abs(latlon[1]) < 0.000000001 )){
			success = parseText(text, "|latdeg=", latDeg, 0) && parseText(text, "|londeg=", lonDeg, 0);
			if(success){
				
				success = parseText(text, "|latmin=", latDeg, 1) | parseText(text, "|lonmin=", lonDeg, 1);
				
				if(success){
					
					success = parseText(text, "|latsec=", latDeg, 2) | parseText(text, "|lonsec=", lonDeg, 2);
				}
				
				
				//Umrechnung von Grad in Dezimal
				latlon[0] = latDeg[0]+(latDeg[1]*60.0+latDeg[2])/3600.0;
				latlon[1] = lonDeg[0]+(lonDeg[1]*60.0+lonDeg[2])/3600.0;
				
				normalizeOld(latlon, text); // �berpr�fen ob �bergeben der Referenz langt!!
				
			} 
		}
		
		return latlon;
	}
	
	private void parseCoordTag(double[] latlon, String text) {
		int start = text.indexOf("{{coord");
		int end = text.indexOf("}}", start);
		
		if(start == -1 || end <= start) return; //Abbruch, tag nicht gefunden
		
		String coordTag = text.substring(start+2, end);
		//System.out.println(coordTag);
		String[] coordFields = coordTag.split("\\|");

		//Siehe Lesezeichen f�r Aufbau, display = title oder displat = title,inline sollte gesetzt sein -> google earth �berspringt inline coords ebenso
		
		//suche und werte Display Attribut aus
		boolean display = false;
		int i;
		for(i = 0; i < coordFields.length; i++){
			if(coordFields[i].startsWith("display")){
				display = true;
				break; //display attribut an der stelle i
			}
		}
		
		if(!display || !coordFields[i].split("=")[1].contains("title")) return; //display ist nicht title oder inline/title

		boolean dec = false; //Koordinate ist dann Dezimal wenn die Zahl einen Punkt beinhaltet um den Nachkommabereich anzudeuten. Im Grad Format nur ganze Zahlen
					// Hemisph�re implizit (N/E) oder explizit m�glich. Im Grad Format NUR explizit
		boolean hemiTags = false;

		int posNS = -1;
		int posEW = -1;
		
		//Suche ob Hemisph�rentags gesetzt sind und wenn ja, wo
		// i resycelt von weiter oben
		String current;
		for(i = 0; i < coordFields.length; i++){
			current = coordFields[i];
			if(current.equals("n") || current.equals("s")) posNS = i;
			if(current.equals("e") || current.equals("w")) posEW = i;
		}
		
		if(posNS > 0 && posEW > 0) hemiTags = true;
		
		// Nun wird �berpr�ft ob es sich um eine dezimale Angabe handelt, in dem beim ersten Wert
		// exemplarisch �berpr�ft wird, ob ein Punkt vorhanden ist
		// sicherere Unterscheidung gew�nscht...
		
		int digitLength = coordFields[1].length();
		char currentChar;
		for(i = 0; i < digitLength; i++){
			currentChar = coordFields[1].charAt(i);
			if(currentChar == '.') dec = true;
		}
		
		if(dec){
			parseCoordDec(coordFields, hemiTags, posNS, posEW, latlon);
		} else {
			parseCoordGrad(coordFields, hemiTags, posNS, posEW, latlon);
		}
	}

	private void parseCoordGrad(String[] coordFields, boolean hemiTags, int posNS, int posEW, double[] latlon) {
		//Hemisph�ren Tags M�SSEN gesetzt sein wenn die Angaben in Grad erfolgen!
		if(!hemiTags){
			System.err.println("Fehler beim Parsen von:");
			for (int i = 0; i < coordFields.length; i++) {
				System.out.println(coordFields[i]);
			}
			return;
		}
		
//		int anzahlLat = posNS - 1; // Wie viel Latitudeangaben sind vorhanden (nur D oder D/M usw)
//		int anzahlLon = posEW - posNS - 1;
//		System.out.println(anzahlLat+" "+anzahlLon);
		boolean north = coordFields[posNS].equals("n") ? true : false;
		boolean east = coordFields[posEW].equals("e") ? true : false;
		
		double[] lat = new double[3];
		double[] lon = new double[3];
		int index = 0;
		for(int i = 1; i < posNS; i++){
			if(!coordFields[i].equals("")) lat[index++] = Double.parseDouble(coordFields[i]);
		}
		
		index = 0;
		for(int i = posNS + 1; i < posEW; i++){
			if(!coordFields[i].equals(""))  lon[index++] = Double.parseDouble(coordFields[i]);
		}
		
		//Umrechnung von Grad in Dezimal
		latlon[0] = lat[0]+(lat[1]*60.0+lat[2])/3600.0;
		latlon[1] = lon[0]+(lon[1]*60.0+lon[2])/3600.0;
		
		if(!north) latlon[0] *= -1;
		if(!east) latlon[1] *= -1;
	}

	private void parseCoordDec(String[] coordFields, boolean hemiTags,
			int posNS, int posEW, double[] latlon) {
		
		int startLat = 1;
		int startLon = hemiTags ? 3 : 2;
		
		StringBuffer buf = new StringBuffer();
		char current;
		
		int index = 0;
		int end = coordFields[startLat].length();
		
		
		do{
			current = coordFields[startLat].charAt(index++);
			buf.append(current);
		}while((index < end) && (current == '.' || current == '-' || Character.isDigit(current)));
		
		latlon[0] = Double.parseDouble(buf.toString());
		
		buf = new StringBuffer();
		index = 0;
		end = coordFields[startLon].length();
		
		do{
			current = coordFields[startLon].charAt(index++);
			buf.append(current);
		}while((index < end) && (current == '.' || current == '-' || Character.isDigit(current)));
		
		latlon[1] = Double.parseDouble(buf.toString());
		
		if(hemiTags){
			latlon[0] = coordFields[posNS].equals("n") ? latlon[0] : latlon[0] * -1;
			latlon[1] = coordFields[posEW].equals("e") ? latlon[1] : latlon[1] * -1;

		}
	}

	private double[] normalize(double[] latlon, String text) {
		boolean south = isSouth(text);
		boolean west = isWest(text);
			
		//Vorzeichenwechsel da Basis-System immer N/E sein soll
		if(south) latlon[0] = latlon[0]* (-1.0);
		if(west) latlon[1] = latlon[1]* (-1.0);
		
		return latlon;
	}
	
	private double[] normalizeOld(double[] latlon, String text) {
		boolean south = isSouthOld(text);
		boolean west = isWestOld(text);
			
		//Vorzeichenwechsel da Basis-System immer N/E sein soll
		if(south) latlon[0] = latlon[0]* (-1.0);
		if(west) latlon[1] = latlon[1]* (-1.0);
		
		return latlon;
	}

	//longEW=E/W
	private boolean isWest(String text) {
		int start = text.indexOf("|longew=");
		if(start == -1) return false;
		
		start += 8;
		
		//int end = text.indexOf('|', start);
		
	//	if(end == -1) end = text.indexOf('}', start);
		
		String sub = text.substring(start, start+1);
		
		
		if(sub.equals("w")) return true;
		
		return false;
		
	}

	//latNS=S/N
	private boolean isSouth(String text) {
		int start = text.indexOf("|latns=");
		if(start == -1) return false;
		
		start += 7;
		
		//int end = text.indexOf('|', start);
		
		//if(end == -1) end = text.indexOf('}', start);
		
		String sub = text.substring(start, start+1);
		
		if(sub.equals("s")) return true;
		
		return false;
	}

	//lonhem=E/W
	private boolean isWestOld(String text) {
		int start = text.indexOf("|lonhem=");
		if(start == -1) return false;
		
		start += 8;
		
		//int end = text.indexOf('|', start);
		
	//	if(end == -1) end = text.indexOf('}', start);
		
		String sub = text.substring(start, start+1);
		
		
		if(sub.equals("w")) return true;
		
		return false;
		
	}

	//lathem=S/N
	private boolean isSouthOld(String text) {
		int start = text.indexOf("|lathem=");
		if(start == -1) return false;
		
		start += 8;
		
		//int end = text.indexOf('|', start);
		
		//if(end == -1) end = text.indexOf('}', start);
		
		String sub = text.substring(start, start+1);
		
		if(sub.equals("s")) return true;
		
		return false;
	}

	private boolean parseText(String text, String criterion, double[] a, int index){
		int start = text.indexOf(criterion);
		if(start == -1) return false;
		
		start += criterion.length();
		try{
			char current;
			current = text.charAt(start);
			StringBuffer buf = new StringBuffer(12);
			
		
			while(Character.isDigit(current) || current == '.' || current == '-'){
				buf.append(current);
				current = text.charAt(++start);
			}

			if(buf.length() == 0){
				a[index] = 0.0;
			} else {
				double rc = Double.parseDouble(buf.toString());
				a[index] = rc;
			}
			
		} catch(Exception e){
			return false;
		}
		
		return true;
	}
	

}
