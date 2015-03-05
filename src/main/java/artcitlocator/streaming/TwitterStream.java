package artcitlocator.streaming;

import artcitlocator.streaming.configuration.jaxb.entity.TwitterRoot;
import artcitlocator.streaming.jaxb.entity.GeoPosition;
import artcitlocator.streaming.jaxb.entity.Hashtag;
import artcitlocator.streaming.jaxb.entity.Place;
import artcitlocator.streaming.jaxb.entity.Tweet;
import artcitlocator.streaming.jaxb.entity.URL;
import artcitlocator.streaming.jaxb.entity.User;
import artcitlocator.streaming.plugin.Manager;
import twitter4j.MediaEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStreamFactory;
import twitter4j.URLEntity;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStream implements Stream {
	private twitter4j.TwitterStream twitterStream;
	private TwitterRoot root;
	
	private boolean RUNNING = true;
	private TwitterFilterQueryInterfaceFactory queryFactory;
	private Manager pluginManager;

	public TwitterStream(TwitterFilterQueryInterfaceFactory queryFactory, TwitterRoot root, Manager pluginManager) {
		this.queryFactory = queryFactory;
		this.root = root;
		this.pluginManager = pluginManager;
	}

	public void init() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(root.getTwitter().getOAuthConsumerKey())
				.setOAuthConsumerSecret(
						root.getTwitter().getOAuthConsumerSecret())
				.setOAuthAccessToken(root.getTwitter().getOAuthAccessToken())
				.setOAuthAccessTokenSecret(
						root.getTwitter().getOAuthAccessTokenSecret());
		TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());
		twitterStream = tsf.getInstance();
		twitterStream.addListener(createListener());
	}

	public void run() {
		twitterStream.addListener(createListener());
		twitterStream.filter(queryFactory.getActualQuery());
		
		while(RUNNING){
			try {
				Thread.sleep(root.getWaitTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		twitterStream.shutdown();
	}

	private StatusListener createListener() {
		return new StatusListener() {
			public void onException(Exception arg0) {
				arg0.printStackTrace();
			}

			public void onDeletionNotice(StatusDeletionNotice arg0) {
				System.err.println("On Deletion Notice UserID: " + arg0.getUserId() + " StatusID " + arg0.getStatusId());
			}

			public void onScrubGeo(long arg0, long arg1) {
				System.out.println("onScrubGeo");
			}

			public void onStallWarning(StallWarning arg0) {
				System.out.println(arg0.getMessage());
			}

			public void onStatus(Status arg0) {
				Tweet tweet = buildTweet(arg0);
				
				pluginManager.process(tweet);
			}

			private Tweet buildTweet(Status arg0) {
				Tweet tweet = new Tweet();
				
				tweet.setText(arg0.getText());
				tweet.setCreateTime(arg0.getCreatedAt().getTime());
				tweet.setFavoriteCount(arg0.getFavoriteCount());
				tweet.setId(arg0.getId());
				tweet.setLanguage(arg0.getLang());
				tweet.setRetweetCount(arg0.getRetweetCount());
				tweet.setSource(arg0.getSource());
								
				Place place = new Place();
				place.setName(arg0.getPlace().getFullName());
				place.setCountry(arg0.getPlace().getCountry());
				place.setCountryCode(arg0.getPlace().getCountryCode());
				place.setStreetAddress(arg0.getPlace().getStreetAddress());
				GeoPosition geo = new GeoPosition();
				geo.setXCoord(arg0.getPlace().getGeometryCoordinates()[0][0].getLatitude());
				geo.setYCoord(arg0.getPlace().getGeometryCoordinates()[0][0].getLongitude());
				place.setGeoPos(geo);
				tweet.setPlace(place);
				
				for (int i = 0; i < arg0.getHashtagEntities().length; i++) {
					Hashtag tag = new Hashtag();
					tag.setText(arg0.getHashtagEntities()[i].getText());
					tweet.getHashtags().add(tag);
				}

				for (MediaEntity entity : arg0.getMediaEntities()) {
					artcitlocator.streaming.jaxb.entity.MediaEntity media = new artcitlocator.streaming.jaxb.entity.MediaEntity();
					media.setText(entity.getMediaURL());
					tweet.getMediaEntities().add(media);
				}
				
				for (URLEntity entity : arg0.getURLEntities()) {
					URL url = new URL();
					url.setText(entity.getExpandedURL());
					tweet.getUrlEntities().add(url);
				}
				
				User user = new User();
				user.setUserID(arg0.getUser().getId());
				user.setName(arg0.getUser().getName());
				tweet.setUser(user);
				
				return tweet;
			}

			public void onTrackLimitationNotice(int arg0) {
				System.err.println("TrackLimitation: " + arg0);
			}
		};
	}

	public void restart() {
		twitterStream.shutdown();
		twitterStream.filter(queryFactory.createFilterQuery());
	}

	public void stop() {
		RUNNING = false;
	}
}
