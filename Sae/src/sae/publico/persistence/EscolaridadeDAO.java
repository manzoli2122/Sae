package sae.publico.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Egresso;
import sae.publico.domain.Escolaridade;

@Local
public interface EscolaridadeDAO extends BaseDAO<Escolaridade> {

	List<Escolaridade> retrieveAllMine(Egresso egresso);

}
