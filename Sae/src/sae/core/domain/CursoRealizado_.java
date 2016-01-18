package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-07T15:31:51.181-0200")
@StaticMetamodel(CursoRealizado.class)
public class CursoRealizado_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<CursoRealizado, String> matricula;
	public static volatile SingularAttribute<CursoRealizado, Date> anoInicio;
	public static volatile SingularAttribute<CursoRealizado, Date> anoTermino;
	public static volatile SingularAttribute<CursoRealizado, Curso> curso;
	public static volatile SingularAttribute<CursoRealizado, Egresso> egresso;
}
