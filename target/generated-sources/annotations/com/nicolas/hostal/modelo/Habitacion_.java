package com.nicolas.hostal.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-13T11:19:06", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> descripcion;
    public static volatile SingularAttribute<Habitacion, String> piso;
    public static volatile SingularAttribute<Habitacion, Boolean> disponibilidad;
    public static volatile SingularAttribute<Habitacion, String> numero;
    public static volatile SingularAttribute<Habitacion, Integer> tipoHabitacionId;

}