package artcitlocator.tools.config;

public interface ConfigHandler {

	public void init(Class<?> clazz, String path);
	
	public Object load();
	
	public boolean save(Object saveObj);
}
