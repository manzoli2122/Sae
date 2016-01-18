package sae.core.application;

import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.TextUtils;
import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Egresso;
import sae.core.persistence.EgressoDAO;

@Stateless
public class ManageEgressoServiceBean  extends CrudServiceBean<Egresso> implements ManageEgressoService{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EgressoDAO egressoDAO;
	
	@Override
	public BaseDAO<Egresso> getDAO() {
		return egressoDAO;
	}

	@Override
	protected Egresso createNewEntity() {
		return new Egresso();
	}

	
	@Override
	public void validateCreate(Egresso entity) throws CrudException {
		try {
			entity.setSenha(TextUtils.produceMd5Hash(entity.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
