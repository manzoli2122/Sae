package sae.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.controller.PersistentObjectConverterFromId;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Assunto_Interesse;
import sae.core.persistence.Assunto_InteresseDAO;

@Stateless
public class ManageAssunto_InteresseSeviceBean  extends CrudServiceBean<Assunto_Interesse> implements ManageAssunto_InteresseSevice{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private Assunto_InteresseDAO assunto_InteresserDAO;
	
	private PersistentObjectConverterFromId<Assunto_Interesse> assuntoConverter;

	@Override
	public BaseDAO<Assunto_Interesse> getDAO() {
		return assunto_InteresserDAO;
	}

	@Override
	protected Assunto_Interesse createNewEntity() {
		return new Assunto_Interesse();
	}
	
	
	@Override
	public Converter getAssuntoConverter() {
		if (assuntoConverter == null) 
			assuntoConverter = new PersistentObjectConverterFromId<Assunto_Interesse>(assunto_InteresserDAO);
		return assuntoConverter;
	}
}
