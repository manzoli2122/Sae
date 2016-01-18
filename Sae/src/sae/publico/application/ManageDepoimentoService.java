package sae.publico.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.publico.domain.Depoimento;

@Local
public interface ManageDepoimentoService extends CrudService<Depoimento> {

}
