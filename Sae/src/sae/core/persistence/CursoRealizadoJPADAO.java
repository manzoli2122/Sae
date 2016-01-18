package sae.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.CursoRealizado;


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
	
	
}
