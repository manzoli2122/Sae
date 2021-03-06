package sae.core.control;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.convert.Converter;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.controller.PersistentObjectConverterFromId;
import sae.core.domain.Administrador;
import sae.core.domain.AssuntoInteresse;
import sae.core.domain.Curso;
import sae.core.domain.CursoRealizado;
import sae.core.domain.Egresso;
import sae.core.domain.Sexo;
import sae.core.persistence.AdministradorDAO;
import sae.core.persistence.AssuntoInteresseDAO;
import sae.core.persistence.CursoDAO;
import sae.core.persistence.CursoRealizadoDAO;
import sae.core.persistence.EgressoDAO;


/**
 * Application-scoped bean that centralizes controller information for the core package. This bean differs from the
 * singleton EJB CoreInformacao by containing data relative to the presentation layer (controller and view, i.e., the
 * web).
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@ApplicationScoped
public class CoreControl  implements Serializable {

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(CoreControl.class.getCanonicalName());
	
	
	
	/** The DAO for Administrador objects. */
	@EJB    	
	private AdministradorDAO administradorDAO;
	
	
	/** The DAO for Assunto_Interesse objects. */
	@EJB
	private AssuntoInteresseDAO assunto_InteresserDAO;
	
	
	/** The DAO for Curso objects. */
	@EJB
	private CursoDAO cursoDAO;
	
	
	/** The DAO for Egresso objects. */
	@EJB
	private EgressoDAO egressoDAO;
	
	
	/** The DAO for Egresso objects. */
	@EJB
	private CursoRealizadoDAO cursoRealizadoDAO;
	
	
	
	
	public String login(){
		return "/core/index.xhtml?faces-redirect=true" ;
	}
	
	
	
	
	
	/** JSF Converter for Administrador objects. */
	private PersistentObjectConverterFromId<Administrador> administradorConverter;
	
	
	/** JSF Converter for Assunto_Interesse objects. */
	private PersistentObjectConverterFromId<AssuntoInteresse> assuntoConverter;
	
	
	/** JSF Converter for Curso objects. */
	private PersistentObjectConverterFromId<Curso> cursoConverter;
	
	
	/** JSF Converter for Curso objects. */
	private PersistentObjectConverterFromId<CursoRealizado> cursoRealizadoConverter;

	
	/** JSF Converter for Egresso objects. */
	private PersistentObjectConverterFromId<Egresso> egressoConverter;
	
	
	
	
	public List<Administrador> getAdministradores(){
		return administradorDAO.retrieveAll();
	}
	
	public List<Egresso> getEgressos(){
		return egressoDAO.retrieveAll();
	}
	
	public List<Curso> getCursos(){
		return cursoDAO.retrieveAll();
	}
	
	
	
	public Sexo[] getSexo() {
		return Sexo.values();
	}
	
	
	
	/** Getter for AdministradorConverter */
	public Converter getAdministradorConverter() {
		// Lazily create the converter.
		if (administradorConverter == null) {
			logger.log(Level.FINEST, "Creating a administrador converter ....... ");
			administradorConverter = new PersistentObjectConverterFromId<Administrador>(administradorDAO);
		}
		return administradorConverter;
	}
	
	
	
	/** Getter for Assunto_InteresseConverter */
	public Converter getAssuntoConverter() {
		if (assuntoConverter == null) {
			logger.log(Level.FINEST, "Creating a assunto_Interesse converter ....... ");
			assuntoConverter = new PersistentObjectConverterFromId<AssuntoInteresse>(assunto_InteresserDAO);
		}
		return assuntoConverter;
	}
	
	
	
	/** Getter for CursoConverter */
	public Converter getCursoConverter() {
		if (cursoConverter == null) {
			logger.log(Level.FINEST, "Creating a curso converter ....... ");
			cursoConverter = new PersistentObjectConverterFromId<Curso>(cursoDAO);
		}	
		return cursoConverter;
	}

	
	
	/** Getter for CursoConverter */
	public Converter getCursoRealizadoConverter() {
		if (cursoRealizadoConverter == null) {
			logger.log(Level.FINEST, "Creating a cursoRealizado converter ....... ");
			cursoRealizadoConverter = new PersistentObjectConverterFromId<CursoRealizado>(cursoRealizadoDAO);
		}	
		return cursoRealizadoConverter;
	}
	
	
	/** Getter for EgressoConverter */
	public Converter getEgressoConverter() {
		if (egressoConverter == null) 
			egressoConverter = new PersistentObjectConverterFromId<Egresso>(egressoDAO);
		return egressoConverter;
	}
	
	
}
