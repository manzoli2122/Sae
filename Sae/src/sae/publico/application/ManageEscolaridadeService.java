package sae.publico.application;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.publico.domain.Escolaridade;

@Local
public interface ManageEscolaridadeService extends CrudService<Escolaridade> {

	List<Escolaridade> retrieveAllMine();

}
