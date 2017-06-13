import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

import de.hofuniversity.fussballdb.djb.HelloBeanRemote;

@ManagedBean
@SessionScoped
public class MessageBean {

    public String getMessage() {
	HelloBeanRemote bean;
	try {
	    bean = (HelloBeanRemote) new InitialDirContext().lookup(HelloBeanRemote.EJB_REF);
	    return bean.getMessage();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
	return "des war nix";
    }

    public void setMessage(String message) {
    }

}
