package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-22T14:27:04.137-0200")
@StaticMetamodel(Administrador.class)
public class Administrador_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Administrador, String> nome;
	public static volatile SingularAttribute<Administrador, String> email;
	public static volatile SingularAttribute<Administrador, String> cpf;
	public static volatile SingularAttribute<Administrador, String> senha;
	public static volatile SingularAttribute<Administrador, String> matricula;
	public static volatile SetAttribute<Administrador, Curso> cursosCoordenados;
}
