package artcitlocator.streaming;

public interface Stream extends Runnable {
	
	public void init();
	
	public void stop();
	
	public void restart();
}
