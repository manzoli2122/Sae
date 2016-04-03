package sae.core.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.Administrador;
import sae.core.domain.Administrador_;


@Stateless
public class AdministradorJPADAO extends BaseJPADAO<Administrador> implements AdministradorDAO{

	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	@Override
	public Class<Administrador> getDomainClass() {
		return Administrador.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Override
	protected List<Order> getOrderList(CriteriaBuilder cb, Root<Administrador> root) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(root.get(Administrador_.nome)));
		return orderList;
	}
	
	
	
	@Override
	public List<Administrador> findByName(String param) {	
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Administrador> cq = cb.createQuery(Administrador.class);
		
		Root<Administrador> root = cq.from(Administrador.class);
		
		cq.where( cb.like(cb.lower(root.get(Administrador_.nome)), param.toLowerCase()+"%")) ;
		
		TypedQuery<Administrador> query = entityManager.createQuery(cq);
		
		List<Administrador> result = query.getResultList();
		
		return result;
	}
	
	
	
	@Override
	public Administrador retrieveByEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Administrador> cq = cb.createQuery(Administrador.class);
		Root<Administrador> root = cq.from(Administrador.class);
		cq.where(  cb.equal(root.get(Administrador_.email), email));
					//cb.equal(root.get(Administrador_.ativo), true));
		
		try {
			Administrador result = getEntityManager().createQuery(cq).getSingleResult();
			return result;
		}
		catch (NoResultException e) {
			throw new PersistentObjectNotFoundException(e, getDomainClass(),email);
		}
		catch (NonUniqueResultException e) {
			throw new MultiplePersistentObjectsFoundException(e, getDomainClass(), email);
		}
		
	}


}
