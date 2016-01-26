package sae.publico.application;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.core.application.SessionService;
import sae.core.domain.Egresso;
import sae.publico.domain.Escolaridade;
import sae.publico.persistence.EscolaridadeDAO;

@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageEscolaridadeServiceBean extends CrudServiceBean<Escolaridade> implements ManageEscolaridadeService{

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ManageEscolaridadeServiceBean.class.getCanonicalName());
	

	@EJB
	private EscolaridadeDAO escolaridadeDAO;
	
	@EJB
	private SessionService sessionService;

	@Override
	public BaseDAO<Escolaridade> getDAO() {
		return escolaridadeDAO;
	}

	@Override
	protected Escolaridade createNewEntity() {
		return new Escolaridade();
	}
	
	@Override
	public void validateCreate(Escolaridade entity) throws CrudException {
		Egresso egresso = sessionService.getEgresso();
		if(egresso != null)
			logger.log(Level.INFO, "egresso = {0} " , egresso.getNome());
		else logger.log(Level.INFO, "EGRESSO NULO");
		entity.setEgresso(egresso);
		
	}
	
	@Override
	public List<Escolaridade>	retrieveAllMine() {
		return escolaridadeDAO.retrieveAllMine(sessionService.getEgresso());
	}
	
	
	
	
	
	
	
}
