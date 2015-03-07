package artcitlocator.wikipedia.crawling.calculation;

import artcitlocator.data.GraphDatabase.NeoJHandler;
import artcitlocator.wikipedia.crawling.control.data.ConnectionCityEntity;

public class ECalculator implements Calculator{

	private NeoJHandler dbHandler;

	public ECalculator(NeoJHandler dbhandler) {
		this.dbHandler = dbhandler;
	}

	public void calculate() {
		long[] relationshipIDs = dbHandler.getAllRelationIDs();
		
		for (int i = 0; i < relationshipIDs.length; i++) {
			ConnectionCityEntity con = dbHandler.getRelationByID(relationshipIDs[i]);
			
			double weight = eCalc(con.getCounterConnection(), con.getCounterEntity());
			
			dbHandler.storeRelationWeight(relationshipIDs[i], weight); 
		}
	}

	private double eCalc(int counterConnection, int counterEntity) {
		double rc;
		rc = Math.E * (counterConnection / counterEntity);
		return rc;
	}

}
