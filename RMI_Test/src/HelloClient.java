import java.rmi.Naming;

public class HelloClient {

    public static void main(String[] args) {
	try {
	    Hello bean = (Hello) Naming.lookup("rmi://localhost/" + Hello.BIND_NAME);
	    System.out.println(bean.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
