package sae.core.application;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;
import sae.core.domain.Administrador;
import sae.core.domain.CursoRealizado;
import sae.core.domain.Egresso;


/**
 * Local EJB interface for the session information component. This bean is responsible for storing information on each
 * different user of the system. 
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Local
public interface SessionService extends Serializable{

	
	/**
	 * Invalidate the user's session and, therefore, log her out of the system.
	 */
	void logout();

	
	/**
	 * Obtains the course list conducted by logged egresso
	 * 
	 * @return course list conducted by logged egresso
	 */
	List<CursoRealizado> getCursoRealizado();
	
	
	/**
	 *  
	 * @return true if exist user logged, otherwise return false.
	 */
	boolean isLoggedIn();
	
	
	

	void getCurrentUser();

	
	/**
	 * Gets decorator according to the currently logged on user
	 * 
	 * @return  folder name where is the decorator
	 */
	String getDecorator();

	
	

	/**
	 * Gets the administrator user currently logged on.
	 * 
	 * @return The Administrator object that represents the user that is currently logged in.
	 */
	Administrador getAdmin();

	
	/**
	 * Gets the Egresso user currently logged on.
	 * 
	 * @return The Egresso object that represents the user that is currently logged in.
	 */
	Egresso getEgresso();

	
	

}
