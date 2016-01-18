package sae.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.SaeConfiguracao;

@Local
public interface SaeConfiguracaoDAO extends BaseDAO<SaeConfiguracao> {

	SaeConfiguracao retrieveCurrentConfiguration() throws PersistentObjectNotFoundException;

}
