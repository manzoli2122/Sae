package sae.core.application;

import javax.ejb.Local;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Egresso;


/**
 * Local EJB interface for the component that implements the "Manage Egresso" use case.
 * 
 * This use case consists of a CRUD for the class Egresso and uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see br.ufes.inf.nemo.util.ejb3.application.CrudService
 */
@Local
public interface ManageEgressoService  extends CrudService<Egresso>{

	
	
	/**
	 * Step of registration process, sends a e-mail so the user can know of your register
	 * 
	 * @param egresso
	 *          Egresso object to which to send the email.
	 */
	void sendEmailCadastro(Egresso egresso);

}
