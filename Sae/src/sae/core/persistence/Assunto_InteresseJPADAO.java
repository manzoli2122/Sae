package sae.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Assunto_Interesse;

@Stateless
public class Assunto_InteresseJPADAO extends BaseJPADAO<Assunto_Interesse> implements Assunto_InteresseDAO{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;

	@Override
	public Class<Assunto_Interesse> getDomainClass() {
		return Assunto_Interesse.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
