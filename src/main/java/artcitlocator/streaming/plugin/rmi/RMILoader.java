package artcitlocator.streaming.plugin.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import artcitlocator.streaming.configuration.jaxb.entity.RMIInformation;
import artcitlocator.streaming.configuration.jaxb.entity.TwitterRoot;
import artcitlocator.streaming.worker.Worker;

public class RMILoader {
	
	public RMILoader() {
		
	}

	public List<Worker> load(TwitterRoot root) {
		List<RMIInformation> pluginList = root.getRMIPlugIns();
		List<Worker> rc = new ArrayList<Worker>();
		
		for (RMIInformation rmiInformation : pluginList) {
			rc.add(connect(rmiInformation));
		}
		
		return rc;
	}

	private Worker connect(RMIInformation rmiInformation) {
		Worker rc = null;
		try {
            // Registry
            Registry registry = LocateRegistry.getRegistry(rmiInformation.getRemoteHost(), rmiInformation.getRemotePort());
            rc = (Worker) registry.lookup(Worker.class.getName());
        } catch (RemoteException e) {
        	e.printStackTrace();
        } catch (NotBoundException e) {
        	e.printStackTrace();
        }
        return rc;
	}
}
