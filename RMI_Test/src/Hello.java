import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{

    public final String BIND_NAME = "hello";
    
    public String getMessage() throws RemoteException;
}
