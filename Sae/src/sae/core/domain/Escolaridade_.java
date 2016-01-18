package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-22T14:43:39.892-0200")
@StaticMetamodel(Escolaridade.class)
public class Escolaridade_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Escolaridade, Egresso> egresso;
	public static volatile SingularAttribute<Escolaridade, String> estado;
	public static volatile SingularAttribute<Escolaridade, String> pais;
	public static volatile SingularAttribute<Escolaridade, String> instituicao;
	public static volatile SingularAttribute<Escolaridade, Date> ano;
	public static volatile SingularAttribute<Escolaridade, Titulo_Escolaridade> titulo;
}
