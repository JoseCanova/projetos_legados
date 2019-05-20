package org.hubotek.samples;

import javax.ejb.EJB;
import javax.faces.bean.*;

import org.hubotek.server.openejb.SessionServerLocal;

@ViewScoped
@ManagedBean(name="sampleBean")
public class SampleMBean {
	
  @EJB
  private SessionServerLocal sessionServer;
	
  private String someProperty = "Blah, blah";

  public String getSomeProperty() {
    return(someProperty);
  }

  public void setSomeProperty(String someProperty) {
    this.someProperty = someProperty + " " + sessionServer.getSomeInfo();
  }
  
  public String someActionControllerMethod() {
    return("page-b");  // Means to go to page-b.xhtml (since condition is not mapped in faces-config.xml)
  }
  
  public String someOtherActionControllerMethod() {
    return("index");  // Means to go to index.xhtml (since condition is not mapped in faces-config.xml)
  }
}