package artcitlocator.streaming;

import twitter4j.FilterQuery;

public interface TwitterFilterQueryInterfaceFactory {

	public FilterQuery createFilterQuery();
	
	public FilterQuery getActualQuery();
}
