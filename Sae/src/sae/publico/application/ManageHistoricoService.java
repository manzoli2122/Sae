package sae.publico.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.publico.domain.Historico_Egresso;

@Local
public interface ManageHistoricoService  extends CrudService<Historico_Egresso>{

}
