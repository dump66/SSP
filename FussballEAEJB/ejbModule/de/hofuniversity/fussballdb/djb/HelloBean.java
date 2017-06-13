package de.hofuniversity.fussballdb.djb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless(mappedName = HelloBeanRemote.EJB_REF)
public class HelloBean implements HelloBeanRemote {
    
    /**
     * Default constructor. 
     */
    public HelloBean() {

    }

    @Override
    public String getMessage() {
	return "Hallo Schlappendach";
    }

}
