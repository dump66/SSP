package de.hofuniversity.fussballdb.djb;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
    public static final String EJB_REF = "ejb/hello";

    public String getMessage();
}
