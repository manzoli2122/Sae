package sae.publico.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Curso;
import sae.core.domain.CursoRealizado;
import sae.core.domain.CursoRealizado_;
import sae.core.domain.Egresso;
import sae.publico.domain.Faixa_Salarial_Enum;
import sae.publico.domain.HistoricoEgresso;
import sae.publico.domain.HistoricoEgresso_;

@Stateless
public class Historico_EgressoJPADAO  extends BaseJPADAO<HistoricoEgresso> implements Historico_EgressoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	
	
	
	
	
	@Override
	public Class<HistoricoEgresso> getDomainClass() {
		return HistoricoEgresso.class;
	}

	
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	
	
	@Override
	protected List<Order> getOrderList(CriteriaBuilder cb, Root<HistoricoEgresso> root) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(root.get(HistoricoEgresso_.data_envio)));
		return orderList;
	}
	
	
	
	@Override
	public long contFaixaSalarial(Faixa_Salarial_Enum faixa, Curso curso){
		
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<HistoricoEgresso> root = cq.from(getDomainClass());
		
		// SUBQUERYH
		Subquery<HistoricoEgresso> subqueryH = cq.subquery(HistoricoEgresso.class);
		Root<HistoricoEgresso> subrootH = subqueryH.from(HistoricoEgresso.class);
		subqueryH.where(
							cb.equal(root.get(HistoricoEgresso_.egresso),subrootH.get(HistoricoEgresso_.egresso)),
							cb.lessThan(root.get(HistoricoEgresso_.data_envio), subrootH.get(HistoricoEgresso_.data_envio))
							
					  );
		subqueryH.select(subrootH);
		
		// SUBQUERY
		Subquery<CursoRealizado> subquery = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subroot = subquery.from(CursoRealizado.class);
		subquery.where(
							cb.equal(root.get(HistoricoEgresso_.egresso),subroot.get(CursoRealizado_.egresso)),
							cb.equal(subroot.get(CursoRealizado_.curso), curso)
					  );
		subquery.select(subroot);
		cq.where(
					cb.equal(root.get(HistoricoEgresso_.faixa_salarial),faixa ),
					cb.exists(  subquery  ),
					cb.not(cb.exists(subqueryH))
				);
		
		
		cq.select(cb.count(root));
		Query q = em.createQuery(cq);

		// Retrieve the value and return.
		long count = ((Long) q.getSingleResult()).longValue();
		return count;
		
	}
	
	
	
	@Override
	public long contReside(Boolean mora, Curso curso){
		
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<HistoricoEgresso> root = cq.from(getDomainClass());
		
		// SUBQUERYH
		Subquery<HistoricoEgresso> subqueryH = cq.subquery(HistoricoEgresso.class);
		Root<HistoricoEgresso> subrootH = subqueryH.from(HistoricoEgresso.class);
		subqueryH.where(
							cb.equal(root.get(HistoricoEgresso_.egresso),subrootH.get(HistoricoEgresso_.egresso)),
							cb.lessThan(root.get(HistoricoEgresso_.data_envio), subrootH.get(HistoricoEgresso_.data_envio))
							
					  );
		subqueryH.select(subrootH);
		
		// SUBQUERY
		Subquery<CursoRealizado> subquery = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subroot = subquery.from(CursoRealizado.class);
		subquery.where(
							cb.equal(root.get(HistoricoEgresso_.egresso),subroot.get(CursoRealizado_.egresso)),
							cb.equal(subroot.get(CursoRealizado_.curso), curso)
					  );
		subquery.select(subroot);
		cq.where(
					cb.equal(root.get(HistoricoEgresso_.reside_no_ES),mora ),
					cb.exists(  subquery  ),
					cb.not(cb.exists(subqueryH))
				);
		
		
		cq.select(cb.count(root));
		Query q = em.createQuery(cq);

		// Retrieve the value and return.
		long count = ((Long) q.getSingleResult()).longValue();
		return count;
		
	}

	
	
	@Override
	public List<HistoricoEgresso> consultaHistorico(Curso curso) {
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		
		CriteriaQuery<HistoricoEgresso> cq = cb.createQuery(HistoricoEgresso.class);
		Root<HistoricoEgresso> root = cq.from(getDomainClass());
		
		
		// SUBQUERYH
		Subquery<HistoricoEgresso> subqueryH = cq.subquery(HistoricoEgresso.class);
		Root<HistoricoEgresso> subrootH = subqueryH.from(HistoricoEgresso.class);
		subqueryH.where(
							cb.equal(root.get(HistoricoEgresso_.egresso),subrootH.get(HistoricoEgresso_.egresso)),
							cb.lessThan(root.get(HistoricoEgresso_.data_envio), subrootH.get(HistoricoEgresso_.data_envio))
							
					  );
		subqueryH.select(subrootH);
		
		// SUBQUERY
		Subquery<CursoRealizado> subquery = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subroot = subquery.from(CursoRealizado.class);
		subquery.where(
							cb.equal(root.get(HistoricoEgresso_.egresso),subroot.get(CursoRealizado_.egresso)),
							cb.equal(subroot.get(CursoRealizado_.curso), curso)
					  );
		subquery.select(subroot);
		cq.where(
					cb.exists(  subquery  ),
					cb.not(cb.exists(subqueryH))
				);
		
		
		cq.select(root);	
		return  em.createQuery(cq).getResultList();
	}

	
	
	@Override
	public List<HistoricoEgresso> retrieveAllMine(Egresso egresso) {
		// Using the entity manager, create a criteria query to retrieve all objects of the domain class.
				EntityManager em = getEntityManager();
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<HistoricoEgresso> cq = cb.createQuery(getDomainClass());
				Root<HistoricoEgresso> root = cq.from(getDomainClass());
				
				cq.where(  cb.equal(root.get(HistoricoEgresso_.egresso), egresso));
				
				cq.select(root);

				// Applies ordering.
				applyOrdering(cb, root, cq);

				// Return the list of objects.
				List<HistoricoEgresso> result = em.createQuery(cq).getResultList();
				return result;
				//return super.retrieveAll();
	}
	
}
