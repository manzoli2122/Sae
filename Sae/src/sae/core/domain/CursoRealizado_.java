package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-04-13T08:58:59.894-0300")
@StaticMetamodel(CursoRealizado.class)
public class CursoRealizado_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<CursoRealizado, String> matricula;
	public static volatile SingularAttribute<CursoRealizado, Integer> anoInicio;
	public static volatile SingularAttribute<CursoRealizado, Integer> anoTermino;
	public static volatile SingularAttribute<CursoRealizado, Curso> curso;
	public static volatile SingularAttribute<CursoRealizado, Egresso> egresso;
}
