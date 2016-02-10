package sae.core.application;

import javax.ejb.Local;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Curso;



/**
 * Local EJB interface for the component that implements the "Manage Curso" use case.
 * 
 * This use case consists of a CRUD for the class Curso and uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see br.ufes.inf.nemo.util.ejb3.application.CrudService
 */
@Local
public interface ManageCursoService  extends CrudService<Curso>{

}
