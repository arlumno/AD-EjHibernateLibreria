package ad.ejhibernatelibreria;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autor.class)
public abstract class Autor_ {

	public static volatile SetAttribute<Autor, Libro> libros;
	public static volatile SingularAttribute<Autor, String> Nacionalidad;
	public static volatile SingularAttribute<Autor, Telefono> telefono;
	public static volatile SingularAttribute<Autor, String> nombre;
	public static volatile SingularAttribute<Autor, String> dni;

	public static final String LIBROS = "libros";
	public static final String NACIONALIDAD = "Nacionalidad";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String DNI = "dni";

}

