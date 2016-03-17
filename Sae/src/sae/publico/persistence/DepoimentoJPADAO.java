package sae.publico.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Administrador;
import sae.core.domain.Curso;
import sae.core.domain.CursoRealizado;
import sae.core.domain.CursoRealizado_;
import sae.core.domain.Egresso;
import sae.publico.domain.Depoimento;
import sae.publico.domain.Depoimento_;
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
		if(autor==null)
			return null;
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Depoimento> cq = cb.createQuery(getDomainClass());
		Root<Depoimento> root = cq.from(getDomainClass());
		
		Subquery<CursoRealizado> subqueryH = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subrootH = subqueryH.from(CursoRealizado.class);
		subqueryH.where(
							cb.equal(subrootH.get(CursoRealizado_.egresso),autor)							
					  );
		
		subqueryH.select(subrootH);
		
		cq.where(
					root.get(Depoimento_.cursoRealizado).in(subqueryH)										
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
	public List<Depoimento> retrieveAllCurso(Curso curso) {
		
		if(curso==null)
			return null;
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Depoimento> cq = cb.createQuery(getDomainClass());
		Root<Depoimento> root = cq.from(getDomainClass());
		
		Subquery<CursoRealizado> subqueryH = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subrootH = subqueryH.from(CursoRealizado.class);
		subqueryH.where(
							cb.equal(subrootH.get(CursoRealizado_.curso),curso)							
					  );
		
		subqueryH.select(subrootH);
		
		cq.where(
					root.get(Depoimento_.cursoRealizado).in(subqueryH)	,	
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
		
		if(admin==null)
			return null;
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		Set<Curso> cursos=  admin.getCursosCoordenados();
		
		CriteriaQuery<Depoimento> cq = cb.createQuery(getDomainClass());
		Root<Depoimento> root = cq.from(getDomainClass());
			
		
		// SUBQUERYCR
		Subquery<CursoRealizado> subqueryCR = cq.subquery(CursoRealizado.class);
		Root<CursoRealizado> subrootCR = subqueryCR.from(CursoRealizado.class);
		subqueryCR.where(
						subrootCR.get(CursoRealizado_.curso).in(cursos)
					  );
		subqueryCR.select(subrootCR);
		
		cq.where(
					cb.equal(root.get(Depoimento_.status), StatusDepoimento_Enum.P),
					root.get(Depoimento_.cursoRealizado).in(subqueryCR)
				);
		
		cq.select(root);

		// Applies ordering.
		applyOrdering(cb, root, cq);

		// Return the list of objects.
		List<Depoimento> result = em.createQuery(cq).getResultList();
		return result;

	}
	

}
