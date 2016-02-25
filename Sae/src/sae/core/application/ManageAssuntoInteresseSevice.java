package sae.core.application;

import javax.ejb.Local;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.AssuntoInteresse;


/**
 * Local EJB interface for the component that implements the "Manage Assunto_Interesse" use case.
 * 
 * This use case consists of a CRUD for the class Assunto_Interesse and uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see br.ufes.inf.nemo.util.ejb3.application.CrudService
 */
@Local
public interface ManageAssuntoInteresseSevice extends CrudService<AssuntoInteresse>{

}
