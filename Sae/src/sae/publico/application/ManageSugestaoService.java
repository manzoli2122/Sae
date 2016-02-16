package sae.publico.application;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.publico.domain.Sugestao;



/**
 * Local EJB interface for the component that implements the "Manage Sugestao" use case.
 * 
 * This use case consists of a CRUD for the class Sugestao and uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see br.ufes.inf.nemo.util.ejb3.application.CrudService
 */
@Local
public interface ManageSugestaoService extends CrudService<Sugestao> {

	List<Sugestao> retrieveAllMine();

}
