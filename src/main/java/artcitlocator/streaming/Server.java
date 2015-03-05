package artcitlocator.streaming;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import artcitlocator.streaming.configuration.jaxb.entity.TwitterRoot;
import artcitlocator.streaming.plugin.Manager;
import artcitlocator.streaming.plugin.rmi.RMILoader;
import artcitlocator.streaming.plugin.rmi.RMIManager;
import artcitlocator.tools.config.ConfigHandler;
import artcitlocator.tools.config.XMLConfigHandler;

public class Server implements Remote{
	private static final String twitterConfFile = "./twitter.xml";
	private Stream streamingSystem;
	private TwitterRoot root;
	private Manager manager;

	public Server() {
		loadTwitterConfig();
		register();
		loadPlugins();
		streamingSystem = new TwitterStream(new TwitterFilterQueryFactory(), root, manager);
		Thread t = new Thread(streamingSystem);
		t.start();
	}

	private void loadPlugins() {
		manager = new RMIManager();
		manager.setWorker(new RMILoader().load(root));
	}

	private void loadTwitterConfig() {
		ConfigHandler xmlConfHandler = new XMLConfigHandler();
		xmlConfHandler.init(TwitterRoot.class, twitterConfFile);
		root = (TwitterRoot) xmlConfHandler.load();

	}
	
	public void register() {
		try {
			LocateRegistry.createRegistry(root.getRMI().getRemotePort());

			RemoteServer.setLog(System.out);

			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(Stream.class.getName(),
					UnicastRemoteObject.exportObject(this, 0));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
