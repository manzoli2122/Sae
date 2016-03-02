package sae.publico.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sae.core.domain.CursoRealizado;

@Generated(value="Dali", date="2016-03-02T17:06:16.710-0300")
@StaticMetamodel(Sugestao.class)
public class Sugestao_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Sugestao, String> conteudo;
	public static volatile SingularAttribute<Sugestao, String> resposta;
	public static volatile SingularAttribute<Sugestao, Date> data_envio;
	public static volatile SingularAttribute<Sugestao, CursoRealizado> cursoRealizado;
}
