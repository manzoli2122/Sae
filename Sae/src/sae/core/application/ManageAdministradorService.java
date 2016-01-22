package sae.core.application;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Administrador;


@Local
public interface ManageAdministradorService extends CrudService<Administrador> {

	Converter getAdministradorConverter();


	void sendEmailCadastro(Administrador entity);

}
