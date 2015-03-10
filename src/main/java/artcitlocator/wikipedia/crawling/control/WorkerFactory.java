package artcitlocator.wikipedia.crawling.control;

import java.util.ArrayList;

import edu.jhu.nlp.wikipedia.WikiPage;
import artcitlocator.data.GraphDatabase.NeoJHandler;

public class WorkerFactory implements Runnable{
	
	private final boolean RUNNING = true;
	
	private static WorkerFactory instance;
	
	private NeoJHandler dbHandler;
	private ArrayList<Worker> workerList;
	private ArrayList<WikiPage> pageList;

	private int pos;

	public WorkerFactory(NeoJHandler dbHandler, int amountWorker) {
		this.dbHandler = dbHandler;
		
		for (int i = 0; i < amountWorker; i++) {
			workerList.add(new Worker(this.dbHandler));
		}
	}

	public void run() {
		while(RUNNING){
			if(pageList.size() == 0) sleep();
			else{
				workerList.get(pos).process(pageList.get(0));
				
				pos = pos + 1;
				if(pos >= workerList.size()){
					pos = 0;
				}
				
				pageList.remove(0);
			}
		}
	}

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addPage(WikiPage page){
		pageList.add(page);
	}

	public static WorkerFactory getInstance(NeoJHandler dbHandler, int amountWorker){
		if(instance == null){
			instance = new WorkerFactory(dbHandler, amountWorker);
			Thread t = new Thread(instance);
			t.start();
		}
		
		return instance;
	}
	


	public static WorkerFactory getInstance(){
		if(instance == null){
			instance = new WorkerFactory(null, 0);
		}
		
		return instance;
	}
}
