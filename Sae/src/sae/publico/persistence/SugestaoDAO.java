package sae.publico.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Egresso;
import sae.publico.domain.Sugestao;

@Local
public interface SugestaoDAO extends BaseDAO<Sugestao> {

	List<Sugestao> retrieveAllMine(Egresso egresso);

}
