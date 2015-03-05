package artcitlocator.streaming;

import java.util.List;

import twitter4j.FilterQuery;
import artcitlocator.streaming.twitter.options.jaxb.entity.Follower;
import artcitlocator.streaming.twitter.options.jaxb.entity.Language;
import artcitlocator.streaming.twitter.options.jaxb.entity.Locations;
import artcitlocator.streaming.twitter.options.jaxb.entity.Track;
import artcitlocator.streaming.twitter.options.jaxb.entity.TwitterOptionsRoot;
import artcitlocator.tools.config.ConfigHandler;
import artcitlocator.tools.config.XMLConfigHandler;

public class TwitterFilterQueryFactory implements TwitterFilterQueryInterfaceFactory{

	private String twitterOptionsFile = "./twitter_options.xml";
	private FilterQuery query = null;
	
	/**
	 * standard constructor if standard filename should be used
	 */
	public TwitterFilterQueryFactory() {
		
	}
	
	/**
	 * constructor for other filenames
	 * @param fileName
	 */
	public TwitterFilterQueryFactory(String fileName){
		twitterOptionsFile = fileName;
	}

	public FilterQuery createFilterQuery() {
		ConfigHandler xmlConfHandler = new XMLConfigHandler();
		xmlConfHandler.init(TwitterOptionsRoot.class, twitterOptionsFile);
		TwitterOptionsRoot optionsRoot = (TwitterOptionsRoot) xmlConfHandler
				.load();

		FilterQuery fq = new FilterQuery();
		fq.count(optionsRoot.getCount());
		fq.follow(getFollower(optionsRoot.getFollower()));
		fq.language(getLanguage(optionsRoot.getLanguage()));
		fq.locations(getLocation(optionsRoot.getLocations()));
		fq.track(getTrack(optionsRoot.getTrack()));
		
		this.query = fq;
		
		return fq;
	}

	private String[] getTrack(List<Track> track) {
		String[] rc = new String[track.size()];
		for (int i = 0; i < rc.length; i++) {
			rc[i] = track.get(i).getKey();
		}
		return rc;
	}

	private double[][] getLocation(List<Locations> locations) {
		double[][] rc = new double[locations.size()][2];
		for (int i = 0; i < rc.length; i++) {
			rc[i][0] = locations.get(i).getXCoord();
			rc[i][1] = locations.get(i).getYCoord();
		}
		return rc;
	}

	private String[] getLanguage(List<Language> language) {
		String[] rc = new String[language.size()];
		for (int i = 0; i < rc.length; i++) {
			rc[i] = language.get(i).getIsoCode();
		}
		return rc;
	}

	private long[] getFollower(List<Follower> follower) {
		long[] rc = new long[follower.size()];
		for (int i = 0; i < rc.length; i++) {
			rc[i] = follower.get(i).getFollowerID();
		}
		return rc;
	}

	public FilterQuery getActualQuery() {
		if(query == null) this.query = createFilterQuery(); 
		return query;
	}
	
}
