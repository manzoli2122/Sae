package sae.publico.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.CursoRealizado;
import sae.core.domain.CursoRealizado_;
import sae.core.domain.Egresso;
import sae.publico.domain.Sugestao;
import sae.publico.domain.Sugestao_;

@Stateless
public class SugestaoJPADAO extends BaseJPADAO<Sugestao> implements SugestaoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;

	@Override
	public Class<Sugestao> getDomainClass() {
		return Sugestao.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Override
	protected List<Order> getOrderList(CriteriaBuilder cb, Root<Sugestao> root) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(root.get(Sugestao_.data_envio)));
		return orderList;
	}

	@Override
	public List<Sugestao> retrieveAllMine(Egresso autor) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Sugestao> cq = cb.createQuery(getDomainClass());
		Root<Sugestao> root = cq.from(getDomainClass());
		
		
		
		Subquery<CursoRealizado> subqueryH = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subrootH = subqueryH.from(CursoRealizado.class);
		subqueryH.where(
							cb.equal(subrootH.get(CursoRealizado_.egresso),autor)							
					  );
		
		subqueryH.select(subrootH);
		
		
		cq.where(
					root.get(Sugestao_.cursoRealizado).in(subqueryH)										
				);

		cq.select(root);

		// Applies ordering.
		applyOrdering(cb, root, cq);

		// Return the list of objects.
		List<Sugestao> result = em.createQuery(cq).getResultList();
		return result;
		
	}
	
	
	
	
	
}
