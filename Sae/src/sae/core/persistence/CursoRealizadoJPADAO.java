package sae.core.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Administrador;
import sae.core.domain.Administrador_;
import sae.core.domain.CursoRealizado;
import sae.core.domain.CursoRealizado_;
import sae.core.domain.Egresso;


@Stateless
public class CursoRealizadoJPADAO extends BaseJPADAO<CursoRealizado> implements CursoRealizadoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	@Override
	public Class<CursoRealizado> getDomainClass() {
		return CursoRealizado.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Override
	protected List<Order> getOrderList(CriteriaBuilder cb, Root<CursoRealizado> root) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(root.get(CursoRealizado_.curso.getName())));
		//orderList.add(cb.asc(root.get(CursoRealizado_.egresso.getName())));
		return orderList;
	}
	
	@Override
	public List<CursoRealizado> retrieveMyCursos(Egresso egresso){
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CursoRealizado> cq = cb.createQuery(getDomainClass());
		Root<CursoRealizado> root = cq.from(getDomainClass());		
		cq.where(cb.equal(root.get(CursoRealizado_.egresso),egresso));
		cq.select(root);
		applyOrdering(cb, root, cq);
		List<CursoRealizado> result = em.createQuery(cq).getResultList();
		return result;
	}

	
}
