package sae.core.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.SaeConfiguracao;
import sae.core.domain.SaeConfiguracao_;

@Stateless
public class SaeConfiguracaoJPADAO extends BaseJPADAO<SaeConfiguracao> implements SaeConfiguracaoDAO{

	
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(SaeConfiguracao.class.getCanonicalName());
	
	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	
	@Override
	public Class<SaeConfiguracao> getDomainClass() {
		return SaeConfiguracao.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public SaeConfiguracao retrieveCurrentConfiguration() throws PersistentObjectNotFoundException {
		logger.log(Level.FINE, "Retrieving current (latest) Sigme configuration...");

		// Constructs the query over the MarvinConfiguration class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SaeConfiguracao> cq = cb.createQuery(SaeConfiguracao.class);
		Root<SaeConfiguracao> root = cq.from(SaeConfiguracao.class);

		// Orders the query descending by date.
		cq.orderBy(cb.desc(root.get(SaeConfiguracao_.creationDate)));
		
		// Retrieves and returns the latest configuration (first entity returned). If the query returns an empty list, throws an exception.
		List<SaeConfiguracao> result = entityManager.createQuery(cq).getResultList();
		try {
			SaeConfiguracao cfg = result.get(0);
			logger.log(Level.INFO, "Retrieve current configuration returned a MarvinConfiguration with institution \"{0}\" and creation date \"{1}\"", new Object[] { cfg.getSmtpUsername(), cfg.getCreationDate() });
			return cfg;
		}
		catch (IndexOutOfBoundsException e) {
			throw new PersistentObjectNotFoundException(e, getDomainClass());
		}
	}

}
