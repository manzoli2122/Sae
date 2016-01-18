package sae.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import sae.core.domain.Administrador;
import sae.core.domain.Egresso;

@Local
public interface SessionService extends Serializable{

	void logout();

	Boolean isSystemInstalled();

	void getCurrentUser();

	String getDecorator();

	boolean isLoggedIn();

	Administrador getAdmin();

	Egresso getEgresso();

}
