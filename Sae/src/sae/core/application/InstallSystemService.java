package sae.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import sae.core.domain.SaeConfiguracao;


/**
 * Local EJB interface for the component that implements the "InstallSystem" use case.
 *
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Local
public interface InstallSystemService extends Serializable{

	void installSystem(SaeConfiguracao config) throws Exception;

}
