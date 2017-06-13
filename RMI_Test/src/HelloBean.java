import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloBean extends UnicastRemoteObject implements Hello {

    protected HelloBean() throws RemoteException{
	super();
    }
    
    @Override
    public String getMessage() throws RemoteException{
	return "Hallo Simon";
    }
}
