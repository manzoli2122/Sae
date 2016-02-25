package sae.publico.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Administrador;
import sae.core.domain.Curso;
import sae.core.domain.CursoRealizado;
import sae.core.domain.CursoRealizado_;
import sae.core.domain.Curso_;
import sae.core.domain.Egresso;
import sae.publico.domain.Depoimento;
import sae.publico.domain.Depoimento_;
import sae.publico.domain.HistoricoEgresso;
import sae.publico.domain.HistoricoEgresso_;
import sae.publico.domain.StatusDepoimento_Enum;





@Stateless
public class DepoimentoJPADAO extends BaseJPADAO<Depoimento> implements DepoimentoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	
	@Override
	public Class<Depoimento> getDomainClass() {
		return Depoimento.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Override
	protected List<Order> getOrderList(CriteriaBuilder cb, Root<Depoimento> root) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(root.get(Depoimento_.data_envio)));
		return orderList;
	}

	@Override
	public List<Depoimento> retrieveAllMine(Egresso autor) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Depoimento> cq = cb.createQuery(getDomainClass());
		Root<Depoimento> root = cq.from(getDomainClass());
		
		cq.where(  cb.equal(root.get(Depoimento_.autor), autor));
		
		cq.select(root);

		// Applies ordering.
		applyOrdering(cb, root, cq);

		// Return the list of objects.
		List<Depoimento> result = em.createQuery(cq).getResultList();
		return result;
		//return super.retrieveAll();
	}
	
	
	
	@Override
	public List<Depoimento> retrieveAllCurso(Curso curso) {
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Depoimento> cq = cb.createQuery(getDomainClass());
		Root<Depoimento> root = cq.from(getDomainClass());
		
		cq.where(  
						cb.equal(root.get(Depoimento_.curso), curso),
						cb.equal(root.get(Depoimento_.status), StatusDepoimento_Enum.A)
						
				);
		
		cq.select(root);

		// Applies ordering.
		applyOrdering(cb, root, cq);

		// Return the list of objects.
		List<Depoimento> result = em.createQuery(cq).getResultList();
		return result;
		//return super.retrieveAll();
	}

	
	
	@Override
	public List<Depoimento> retrieveAllAnalisar(Administrador admin) {
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Depoimento> cq = cb.createQuery(getDomainClass());
		Root<Depoimento> root = cq.from(getDomainClass());
		
		// SUBQUERYH
		Subquery<Curso> subqueryH = cq.subquery(Curso.class);
		Root<Curso> subrootH = subqueryH.from(Curso.class);
		subqueryH.where(
							cb.equal(subrootH.get(Curso_.coordenador),admin),
							cb.equal(subrootH,root.get(Depoimento_.curso))
							
					  );
		subqueryH.select(subrootH);
		
		cq.where(
					cb.equal(root.get(Depoimento_.status), StatusDepoimento_Enum.P),
					cb.exists(  subqueryH  )
					
				);
		
		cq.select(root);

		// Applies ordering.
		applyOrdering(cb, root, cq);

		// Return the list of objects.
		List<Depoimento> result = em.createQuery(cq).getResultList();
		return result;

	}
	

}
