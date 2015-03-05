package artcitlocator.streaming.plugin;

import java.util.List;

import artcitlocator.streaming.jaxb.entity.Tweet;
import artcitlocator.streaming.worker.Worker;

public interface Manager {

	public void process(Tweet tweet);
	
	public void setWorker(List<Worker> worker);
}
