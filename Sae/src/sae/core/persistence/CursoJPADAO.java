package sae.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Curso;

@Stateless
public class CursoJPADAO extends BaseJPADAO<Curso> implements CursoDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	@Override
	public Class<Curso> getDomainClass() {
		return Curso.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
