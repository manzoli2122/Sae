package sae.publico.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.publico.domain.Historico_Egresso;


/**
 * Local EJB interface for the component that implements the "Manage Historico" use case.
 * 
 * This use case consists of a CRUD for the class Historico and uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see br.ufes.inf.nemo.util.ejb3.application.CrudService
 */
@Local
public interface ManageHistoricoService  extends CrudService<Historico_Egresso>{

}
