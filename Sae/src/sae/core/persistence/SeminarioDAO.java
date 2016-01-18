package sae.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Seminario;

@Local
public interface SeminarioDAO extends BaseDAO<Seminario>{

}
