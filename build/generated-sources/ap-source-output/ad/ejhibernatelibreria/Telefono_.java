package ad.ejhibernatelibreria;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Telefono.class)
public abstract class Telefono_ {

	public static volatile SingularAttribute<Telefono, String> numeroTf;
	public static volatile SingularAttribute<Telefono, String> dni;
	public static volatile SingularAttribute<Telefono, Autor> autor;

	public static final String NUMERO_TF = "numeroTf";
	public static final String DNI = "dni";
	public static final String AUTOR = "autor";

}

