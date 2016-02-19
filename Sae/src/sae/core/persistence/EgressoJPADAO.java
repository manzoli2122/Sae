package sae.core.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.Egresso;
import sae.core.domain.Egresso_;

@Stateless
public class EgressoJPADAO extends BaseJPADAO<Egresso> implements EgressoDAO{

	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	@Override
	public Class<Egresso> getDomainClass() {
		return Egresso.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	
	@Override
	protected List<Order> getOrderList(CriteriaBuilder cb, Root<Egresso> root) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(root.get(Egresso_.nome)));
		return orderList;
	}
	
	
	
	
	
	
	@Override
	public Egresso retrieveByEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Egresso> cq = cb.createQuery(Egresso.class);
		Root<Egresso> root = cq.from(Egresso.class);
		cq.where(  cb.equal(root.get(Egresso_.email), email));
					//cb.equal(root.get(Administrador_.ativo), true));
		
		try {
			Egresso result = getEntityManager().createQuery(cq).getSingleResult();
			return result;
		}
		catch (NoResultException e) {
			throw new PersistentObjectNotFoundException(e, getDomainClass(),email);
		}
		catch (NonUniqueResultException e) {
			throw new MultiplePersistentObjectsFoundException(e, getDomainClass(), email);
		}	
	}

	
	
	
	
	@Override
	public List<Egresso> findByName(String name) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Egresso> cq = cb.createQuery(Egresso.class);
		Root<Egresso> root = cq.from(Egresso.class);

		cq.where(cb.like(cb.lower(root.get(Egresso_.nome)), name.toLowerCase() + "%"));
		cq.orderBy(cb.asc(root.get(Egresso_.nome)));

		List<Egresso> result = entityManager.createQuery(cq).getResultList();
		return result;
	}
	
	
	
	
	
}
