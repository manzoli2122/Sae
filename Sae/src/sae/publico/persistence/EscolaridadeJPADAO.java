package sae.publico.persistence;

import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Administrador_;
import sae.core.domain.Egresso;
import sae.publico.domain.Escolaridade;
import sae.publico.domain.Escolaridade_;


@Stateless
public class EscolaridadeJPADAO extends BaseJPADAO<Escolaridade> implements EscolaridadeDAO{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;

	@Override
	public Class<Escolaridade> getDomainClass() {
		return Escolaridade.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<Escolaridade> retrieveAllMine(Egresso egresso) {
		
		// Using the entity manager, create a criteria query to retrieve all objects of the domain class.
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Escolaridade> cq = cb.createQuery(getDomainClass());
		Root<Escolaridade> root = cq.from(getDomainClass());
		
		cq.where(  cb.equal(root.get(Escolaridade_.egresso), egresso));
		
		cq.select(root);

		// Applies ordering.
		applyOrdering(cb, root, cq);

		// Return the list of objects.
		List<Escolaridade> result = em.createQuery(cq).getResultList();
		return result;
		//return super.retrieveAll();
	}
}
