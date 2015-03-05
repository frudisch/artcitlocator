package artcitlocator.crawling.control;

public class LonLatParser {

	/**
	 * 
	 * pos0: Lond pos1: Lonm pos2: Lons pos3: Latd pos4: Latm pos5: Lats
	 * 
	 * @param text
	 * @return
	 */

	public double[] getLonLat(String text) {
		
		

		double[] array = new double[6];

		text = text.replaceAll("\\s", "");
		text = text.toLowerCase();

		// System.out.println(text);

		// Longitude Degrees
		array[0]=parseText(text, "|longd=");
		// Longitude Minutes
		array[1]=parseText(text, "|longm=");
		// Longitude Seconds
		array[2]=parseText(text, "|longs=");
		// Latitude Degrees
		array[3]=parseText(text, "|latd=");
		// Latitude Minute
		array[4]=parseText(text, "|latm=");
		// Latitude Seconds
		array[5]=parseText(text, "|lats=");
		
		
		int error = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i]==99999) {
				error++;
				array[i]=0;
			}
		}
		
		if (error==6) {
			return null;
		}
		

		return array;
	}
	
	private double parseText(String text,String criterion){
		try{
		int start, end;
		
		start = text.indexOf(criterion) + criterion.length();
		end = start;
		while ((Character.isDigit(text.charAt(end))) || '.' == text.charAt(end)) {
			end++;
		}
		if (end == -1 || start == -1) {
			return 99999;
		} else if (start < end) {
			return Double.parseDouble(text.substring(start, end));
		} 
		}catch (Exception e){
			e.printStackTrace();
			
			System.exit(0);
		}
		return 99999;
		
		
		
	}
}
