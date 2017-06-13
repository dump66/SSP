import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

    public static void main(String[] args) throws AccessException, RemoteException {

	Registry registry = null;
	try {
	    registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	} catch (Exception e) {
	    try {
		registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
	    } catch (RemoteException e1) {
		e1.printStackTrace();
	    }
	}
	registry.rebind("hello", new HelloBean());
	System.out.println("Server running...");
    }

}
