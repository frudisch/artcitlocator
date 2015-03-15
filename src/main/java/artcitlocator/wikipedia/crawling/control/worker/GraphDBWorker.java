package artcitlocator.wikipedia.crawling.control.worker;

import java.util.ArrayDeque;

import artcitlocator.data.GraphDatabase.NeoJHandler;
import artcitlocator.wikipedia.crawling.control.CityCreator;
import artcitlocator.wikipedia.crawling.control.data.City;
import edu.jhu.nlp.wikipedia.WikiPage;

public class GraphDBWorker implements Worker{

	private boolean RUNNING = true;
	private NeoJHandler dbHandler;
	private CityCreator cityCreator;
	private ArrayDeque<WikiPage> toDo;
	private int id;

	public GraphDBWorker(NeoJHandler dbHandler, int id) {
		this.dbHandler = dbHandler;
		this.cityCreator = new CityCreator();
		this.toDo = new ArrayDeque<WikiPage>();
		this.id = id;
	}

	public GraphDBWorker() {
		this.toDo = new ArrayDeque<WikiPage>();
		this.cityCreator = new CityCreator();
	}

	public void process(WikiPage page) {
		synchronized(toDo){
			toDo.add(page);
		}
	}

	public void run() {
		while (RUNNING) {
			if (toDo.peek() != null) {
				WikiPage page;
				synchronized(toDo){
					page = toDo.poll();
				}
				City temp = cityCreator.extractCity(page.getTitle(), page.getText());

				if (temp != null) {
					try{
						dbHandler.saveCity(temp);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				
//				System.out.println("Worker " + id + " in liste: " + toDo.size());
			} else {
				sleep();
			}
		}
		dbHandler.shutdown();
	}

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public NeoJHandler getDbHandler() {
		return dbHandler;
	}

	public void setDbHandler(NeoJHandler dbHandler) {
		this.dbHandler = dbHandler;
	}

	public CityCreator getCityCreator() {
		return cityCreator;
	}

	public void setCityCreator(CityCreator cityCreator) {
		this.cityCreator = cityCreator;
	}

	public ArrayDeque<WikiPage> getToDo() {
		return toDo;
	}

	public void setToDo(ArrayDeque<WikiPage> toDo) {
		this.toDo = toDo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	public void setHandler(DatabaseHandler dbHandler) {
		this.dbHandler = (NeoJHandler) dbHandler;
	}

	public Worker newInstance() {
		return new GraphDBWorker();
	}
}
