package sae.publico.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Curso;
import sae.core.domain.CursoRealizado;
import sae.core.domain.CursoRealizado_;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Historico_Egresso;
import sae.publico.domain.Historico_Egresso_;

@Stateless
public class Historico_EgressoJPADAO  extends BaseJPADAO<Historico_Egresso> implements Historico_EgressoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	@Override
	public Class<Historico_Egresso> getDomainClass() {
		return Historico_Egresso.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	
	
	
	@Override
	public long contFaixaSalarial(Faixa_Salarial faixa, Curso curso){
		
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Historico_Egresso> root = cq.from(getDomainClass());
		
		// SUBQUERYH
		Subquery<Historico_Egresso> subqueryH = cq.subquery(Historico_Egresso.class);
		Root<Historico_Egresso> subrootH = subqueryH.from(Historico_Egresso.class);
		subqueryH.where(
							cb.equal(root.get(Historico_Egresso_.egresso),subrootH.get(Historico_Egresso_.egresso)),
							cb.lessThan(root.get(Historico_Egresso_.data_envio), subrootH.get(Historico_Egresso_.data_envio))
							
					  );
		subqueryH.select(subrootH);
		
		// SUBQUERY
		Subquery<CursoRealizado> subquery = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subroot = subquery.from(CursoRealizado.class);
		subquery.where(
							cb.equal(root.get(Historico_Egresso_.egresso),subroot.get(CursoRealizado_.egresso)),
							cb.equal(subroot.get(CursoRealizado_.curso), curso)
					  );
		subquery.select(subroot);
		cq.where(
					cb.equal(root.get(Historico_Egresso_.faixa_salarial),faixa ),
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
		Root<Historico_Egresso> root = cq.from(getDomainClass());
		
		// SUBQUERYH
		Subquery<Historico_Egresso> subqueryH = cq.subquery(Historico_Egresso.class);
		Root<Historico_Egresso> subrootH = subqueryH.from(Historico_Egresso.class);
		subqueryH.where(
							cb.equal(root.get(Historico_Egresso_.egresso),subrootH.get(Historico_Egresso_.egresso)),
							cb.lessThan(root.get(Historico_Egresso_.data_envio), subrootH.get(Historico_Egresso_.data_envio))
							
					  );
		subqueryH.select(subrootH);
		
		// SUBQUERY
		Subquery<CursoRealizado> subquery = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subroot = subquery.from(CursoRealizado.class);
		subquery.where(
							cb.equal(root.get(Historico_Egresso_.egresso),subroot.get(CursoRealizado_.egresso)),
							cb.equal(subroot.get(CursoRealizado_.curso), curso)
					  );
		subquery.select(subroot);
		cq.where(
					cb.equal(root.get(Historico_Egresso_.reside_no_ES),mora ),
					cb.exists(  subquery  ),
					cb.not(cb.exists(subqueryH))
				);
		
		
		cq.select(cb.count(root));
		Query q = em.createQuery(cq);

		// Retrieve the value and return.
		long count = ((Long) q.getSingleResult()).longValue();
		return count;
		
	}
	
}
