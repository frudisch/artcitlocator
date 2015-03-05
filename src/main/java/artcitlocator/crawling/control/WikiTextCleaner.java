package artcitlocator.crawling.control;

public class WikiTextCleaner {
	
	
//	public static void main(String[] args) {
//		
//		String text = "Hallo [[Daniel]] du [[Bauer]] geh nach [Hause], du weist schon in [[Orte am Arsch der Welt| Feilitzsch]] ";
//		//String text = "{{About|the capital of France}} {{pp-pc1}} {{good article}} {{Use dmy dates|date=May 2013}} {{Use British English|date=May 2013}} {{Infobox French commune |name = Paris |image = <imagemap> File:Paris montage2.jpg|275px|alt=Paris montage. Clicking on an image in the picture causes the browser to load the appropriate article. rect 0 0 1200 441 [[Le Louvre]] rect 0 1260 618 1398 [[Champs de Mars]] rect 0 447 618 1398 [[Eiffel Tower]] rect 618 447 1200 1056 [[Arc de Triomphe|Arc de Triomphe de l'�toile]] rect 618 1056 1200 1398 [[La D�fense]] rect 21 1521 117 1632 [[Palais de Justice, Paris|Palais de Justice]] rect 120 1521 165 1632 [[Tribunal de Commerce]] rect 369 1494 412 1575 [[Sainte-Chapelle]] rect 456 1512 540 1569 [[Notre Dame Cathedral]] rect 750 1524 1200 1680 [[Institut de France]] rect 0 1635 600 1650 [[Pont Neuf]] rect 0 1650 750 1680 [[Pont des Arts]] rect 0 1395 1200 1695 [[�le de la Cit�]] rect 0 1395 1200 1803 [[Seine]] </imagemap> |caption =Clockwise: [[Louvre Pyramid]], [[Arc de Triomphe]], looking towards [[La D�fense]], skyline of Paris on the [[Seine]] river with the [[Pont des Arts]] bridge, and the [[Eiffel Tower]] - clickable image |image flag = Flag of Paris.svg |image flag size = 100px |image coat of arms = Grandes Armes de Paris.svg |image coat of arms size = 120px |flag legend = [[Flag of Paris|City flag]] |coat of arms legend = [[Coat of arms of Paris|City coat of arms]] |city motto = ''[[Fluctuat nec mergitur]]''<br />(Latin: She is tossed by the waves but does not sink) |latitude = 48.8567 |longitude = 2.3508 |time zone = [[Central European Time|CET]] <small>(UTC +1)</small> |mayor = [[Anne Hidalgo]] |party = [[Socialist Party (France)|PS]] |term = since 5 April 2014 |subdivisions entry = [[Administrative division|Subdivisions]] |subdivisions = [[Arrondissements of Paris|20 arrondissements]] |area km2 = 105.4 |area footnotes =<ref name=area>[http://www.statistiques-locales.insee.fr/Fiches%5CRS%5CDEP%5C75%5CCOM%5CRS_COM75056.pdf INSEE local statistics], including [[Bois de Boulogne]] and [[Bois de Vincennes]].</ref> |INSEE=75056 |postal code=75001-75020, 75116 |un_locode = FRPAR |population_demonym = Parisian(s) |population = 2243833 |population date = 2010<ref name=paris_pop_2010>{{Fr icon}} {{cite web|url=http://www.insee.fr/fr/themes/tableau_local.asp?ref_id=POP&millesime=2010&nivgeo=COM&codgeo=75056|title=Chiffres cl�s �volution et structure de la population - Commune de Paris (75056)|author=[[INSEE|Institut National de la Statistique et des �tudes �conomiques]]|accessdate=7 July 2013}}</ref> |population ranking = [[List of communes in France with over 20,000 inhabitants (1999 census)|1st in France]] |urban area km2 = 2844.8 |urban area date = 2010 |urban pop = 10,413,386<ref name=paris_UU10_pop>{{cite web|url=http://www.recensement.insee.fr/chiffresCles.action?codeMessage=5&plusieursReponses=true&zoneSearchField=PARIS&codeZone=00851-UU2010&idTheme=3&rechercher=Rechercher|title=Unit� urbaine 2010 : Paris (00851)|publisher=INSEE|language=French|accessdate=3 July 2012}}</ref> |urban pop date = Jan.&nbsp;2009 |metro area km2 = 17174.4 |metro area date = 2010 |metro area pop = 12,161,542<ref>{{cite web|url=http://www.recensement.insee.fr/chiffresCles.action?codeMessage=5&plusieursReponses=true&zoneSearchField=PARIS&codeZone=001-AU2010&idTheme=3&rechercher=Rechercher|title=Aire urbaine 2010 : Paris (001)|publisher=INSEE|accessdate=21 October 2011}}</ref><ref name=paris_AU10_pop>{{cite web|url=http://www.recensement.insee.fr/chiffresCles.action?zoneSearchField=PARIS&codeZone=001-AU2010&idTheme=3|title=Aire urbaine 2010 : Paris (001)|publisher=INSEE|language=French|accessdate=3 July 2012}}</ref> |metro area pop date = Jan.&nbsp;2009 |website = [http://www.paris.fr/ www.paris.fr] }} {{pp-move-indef}} '''Paris''' ({{IPAc-en|lang||p|�r||s|}}, {{IPAc-en||p|r||s|audio=En-us-Paris.ogg}}; {{IPA-fr|pai|lang|Paris1.ogg}}) is the capital and most populous city of [[France]]. It is situated on the [[Seine]] River, in the north of the country, at the heart of the [[�le-de-France]] [[Regions of France|region]]. Within its administrative limits (the 20 [[arrondissements of Paris|arrondissements]]), the city had 2,243,833 inhabitants in 2010 while its [[Paris aire urbaine|metropolitan area]] is [[List of metropolitan areas in Europe|one of the largest population centres in Europe]] with more than 12&nbsp;million inhabitants.";
//		WikiTextCleaner cleaner = new WikiTextCleaner();
//		System.out.println(cleaner.cleanText(text));
//		
//	}
	
	
	public String cleanText(String text){
		 StringBuilder builder = new StringBuilder(text);
		 
		 int openBreak = 0;
		 char current;
		 
		 //remove {}
		 for(int i = 0; i < builder.length(); i++){
			 current = builder.charAt(i);
			 
			 if(current == '{'){
				// System.out.println("Klammer bei: "+i);
				 int start = i;
				 openBreak = 1;
				 
				 while(openBreak > 0 && ++i < builder.length()){
					 current = builder.charAt(i);
					 
					 if(current == '{') openBreak++;
					 if(current == '}') openBreak--;
					 //System.out.println("In der while");
				 }
				 
				 builder.delete(start, i+1);
				 i = start;
			 }
			 
			 
		 }
		 
		 //remove []
		 
		 char current2;
		 String linkText;
		 String[] linkTextTags;
		 for(int i = 0; i < builder.length()-2; i++){
			 current = builder.charAt(i);
			 current2 = builder.charAt(i+1);
			 
			 if(current == '[' && current2 == '['){
				int start = i;
				openBreak = 1;
				
				 while(openBreak > 0 && ++i < builder.length()){
					 current = builder.charAt(i);
					 
					 if(current == '[') openBreak++;
					 if(current == ']') openBreak--;
					 //System.out.println("In der while");
				 }
				 
				 linkText = builder.substring(start+2, i-1);
				 linkTextTags = linkText.split("\\|");
				 linkText =  linkTextTags.length > 1 ? linkTextTags[1] : linkTextTags[0];
				 builder.replace(start, i+1, linkText);
				 
				 i = start + linkText.length();
			 }
		 }
		 
		 return builder.toString();
		 
	}

}
