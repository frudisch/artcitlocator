package artcitlocator.streaming.worker;

import java.rmi.Remote;

import artcitlocator.streaming.jaxb.entity.Tweet;

public interface Worker extends Remote{

	public void process(Tweet tweet);
}
