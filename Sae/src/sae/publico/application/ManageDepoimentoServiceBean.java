package sae.publico.application;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.login.SessionService;
import sae.publico.domain.Depoimento;
import sae.publico.domain.StatusDepoimento;
import sae.publico.persistence.DepoimentoDAO;




/**
 * Stateless session bean implementing the "Manage Depoimento" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.publico.application.ManageDepoimentoService
 */
@Stateless
@DeclareRoles({"Admin", "egresso", "guest"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageDepoimentoServiceBean extends CrudServiceBean<Depoimento> implements ManageDepoimentoService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	
	/** The DAO for Depoimento objects. */
	@EJB
	private DepoimentoDAO depoimentoDAO;
	
	

	@EJB
	private SessionService sessionService;
	
	
	
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Depoimento> getDAO() {
		return depoimentoDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Depoimento createNewEntity() {
		return new Depoimento();
	}
	
	
	
	
	/** @see sae.core.application.CrudServiceBean#validateCreate(br.ufes.inf.nemo.util.ejb3.persistence.PersistentObject) */
	@Override
	public void validateCreate(Depoimento entity) throws CrudException {
		entity.setStatus(StatusDepoimento.PENDENTE);
	}
	
	
	
	@Override
	public void validateUpdate(Depoimento entity) throws CrudException {
		entity.setStatus(StatusDepoimento.PENDENTE);
	}
	
	
	
	
	@Override
	public void aprovar(Depoimento entity){
		entity.setStatus(StatusDepoimento.APROVADO);
		update(entity);
	}

	@Override
	public void desaprovar(Depoimento entity){
		entity.setStatus(StatusDepoimento.DESAPROVADO);
		update(entity);
	}
	
	
	@Override
	public List<Depoimento>	retrieveAllMine() {
		return depoimentoDAO.retrieveAllMine(sessionService.getEgresso());
	}
	
	
	
	@Override
	public List<Depoimento>	retrieveAllAnalisar() {
		return depoimentoDAO.retrieveAllAnalisar(sessionService.getAdmin());
	}
	
	
	

}
