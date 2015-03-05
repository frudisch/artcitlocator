package artcitlocator.crawling.control.data;

import java.util.ArrayList;

public class City implements Comparable<City>{
	
	private String name;
	private double longi;
	private double lati;
	private double score;
	private int id;
	private int counter;
	private ArrayList<Entity> entities;
	
	public City(int id, String name, double latitude, double longitude){
		setId(id);
		setName(name);
		setLongi(longitude);
		setLati(latitude);
		setCounter(1);
		setScore(1);
	}
	
	public City( String name, double latitude, double longitude){
		setName(name);
		setLongi(longitude);
		setLati(latitude);
		setCounter(1);
		setScore(1);
	}
	
	public City(String name, String latitude, String longitude) {
		setName(name);
		setLati(Double.parseDouble(latitude));
		setLongi(Double.parseDouble(longitude));
		setCounter(1);
		setScore(1);
	}

	public City(String name, String latitude, String longitude, ArrayList<Entity> entities) {
		setName(name);
		setLati(Double.parseDouble(latitude));
		setLongi(Double.parseDouble(longitude));
		setCounter(1);
		setScore(1);
		setEntities(entities);
	}
	
	public String cityToString(){
		return getName() + "; " + getLati() + ";" + getLongi();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongi() {
		return longi;
	}

	public void setLongi(double longi) {
		this.longi = longi;
	}

	public double getLati() {
		return lati;
	}

	public void setLati(double lati) {
		this.lati = lati;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int compareTo(City o) {
		return Double.compare(o.score, this.score);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
