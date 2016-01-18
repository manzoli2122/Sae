package sae.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import sae.core.domain.SaeConfiguracao;

@Local
public interface InstallSystemService extends Serializable{

	void installSystem(SaeConfiguracao config) throws Exception;

}
