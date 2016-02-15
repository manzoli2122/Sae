package sae.publico.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.publico.domain.Depoimento;


/**
 * Local EJB interface for the component that implements the "Manage Depoimento" use case.
 * 
 * This use case consists of a CRUD for the class Depoimento and uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see br.ufes.inf.nemo.util.ejb3.application.CrudService
 */
@Local
public interface ManageDepoimentoService extends CrudService<Depoimento> {

}
