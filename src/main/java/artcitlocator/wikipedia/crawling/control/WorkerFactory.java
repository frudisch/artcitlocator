package artcitlocator.wikipedia.crawling.control;

import java.util.ArrayList;

import edu.jhu.nlp.wikipedia.WikiPage;
import artcitlocator.wikipedia.crawling.control.worker.DatabaseHandler;
import artcitlocator.wikipedia.crawling.control.worker.Worker;

public class WorkerFactory implements Runnable {

	private final boolean RUNNING = true;

	private ArrayList<Worker> workerList;
	private ArrayList<WikiPage> pageList;
	private ArrayList<Thread> threadList;

	private int counter;

	private int pos;

	public WorkerFactory(DatabaseHandler dbHandler, int amountWorker, Worker clazz) {
		this.workerList = new ArrayList<Worker>();
		this.pageList = new ArrayList<WikiPage>();
		this.threadList = new ArrayList<Thread>();
		this.pos = 0;

		for (int i = 0; i < amountWorker; i++) {
			Worker worker;
			worker = clazz.newInstance();

			worker.setHandler(dbHandler);
			worker.setID(i);
			workerList.add(worker);
			Thread t = new Thread(worker);
			threadList.add(t);
			t.start();
		}
	}

	public void run() {
		while (RUNNING) {
			try {
				if (pageList.size() == 0) {
					sleep();
				} else {
					workerList.get(pos).process(pageList.get(0));

					counter = counter + 1;
					if(counter%1000 == 0) System.out.println(counter + " " + RUNNING + " in Liste: " + pageList.size());

					pos = pos + 1;
					if (pos >= workerList.size()) {
						pos = 0;
					}

					pageList.remove(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void sleep() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addPage(WikiPage page) {
		pageList.add(page);
	}
	
	public void join(){
		for (Thread thread : threadList) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
