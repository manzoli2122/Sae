package sae.publico.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.publico.domain.Historico_Egresso;

@Local
public interface Historico_EgressoDAO  extends BaseDAO<Historico_Egresso>{

}
