package sae.publico.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sae.core.domain.Egresso;

@Generated(value="Dali", date="2016-04-13T08:19:11.112-0300")
@StaticMetamodel(Escolaridade.class)
public class Escolaridade_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Escolaridade, Egresso> egresso;
	public static volatile SingularAttribute<Escolaridade, Titulo_Escolaridade_Enum> titulo;
	public static volatile SingularAttribute<Escolaridade, String> estado;
	public static volatile SingularAttribute<Escolaridade, String> pais;
	public static volatile SingularAttribute<Escolaridade, String> instituicao;
	public static volatile SingularAttribute<Escolaridade, Integer> ano;
}
