package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-04-13T08:12:21.061-0300")
@StaticMetamodel(Egresso.class)
public class Egresso_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Egresso, String> nome;
	public static volatile SingularAttribute<Egresso, String> email;
	public static volatile SingularAttribute<Egresso, String> cpf;
	public static volatile SingularAttribute<Egresso, String> senha;
	public static volatile SingularAttribute<Egresso, Date> nascimento;
	public static volatile SingularAttribute<Egresso, String> identidade;
	public static volatile SingularAttribute<Egresso, Sexo> sexo;
	public static volatile SingularAttribute<Egresso, String> nacionalidade;
	public static volatile SingularAttribute<Egresso, String> naturalidade;
}
