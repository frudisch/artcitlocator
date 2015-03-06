package artcitlocator.wikipedia.crawling.control.data;

public class Entity {
	private int id;
	private String name;
	private int count = 1;
	private String type;
	private double idf;
	
	public Entity(String name, String type){
		this.name = name;
		this.type = type;
		this.count = 1;
	}
	
	@Override
	public String toString()
	{
		return "Entity [name=" + name + ", type=" + type + "]";
	}

	public Entity(String name, String type, String count){
		this.name = name;
		this.type = type;
		this.count = Integer.parseInt(count);
	}
	
	public Entity(int id, int counter, double idf) {
		this.setId(id);
		this.count = counter;
		this.setIdf(idf);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getIdf() {
		return idf;
	}

	public void setIdf(double idf) {
		this.idf = idf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
