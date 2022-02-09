package ad.ejhibernatelibreria;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Libro.class)
public abstract class Libro_ {

	public static volatile SingularAttribute<Libro, Float> precio;
	public static volatile SingularAttribute<Libro, String> titulo;
	public static volatile SingularAttribute<Libro, Integer> id;
	public static volatile SetAttribute<Libro, Autor> autores;

	public static final String PRECIO = "precio";
	public static final String TITULO = "titulo";
	public static final String ID = "id";
	public static final String AUTORES = "autores";

}

