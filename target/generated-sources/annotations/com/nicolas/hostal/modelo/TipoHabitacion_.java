package com.nicolas.hostal.modelo;

import com.nicolas.hostal.modelo.Tarifa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-23T13:44:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(TipoHabitacion.class)
public class TipoHabitacion_ { 

    public static volatile SingularAttribute<TipoHabitacion, String> descripcion;
    public static volatile SingularAttribute<TipoHabitacion, Integer> numCamas;
    public static volatile ListAttribute<TipoHabitacion, Tarifa> tarifas;
    public static volatile SingularAttribute<TipoHabitacion, Integer> id;
    public static volatile SingularAttribute<TipoHabitacion, Integer> numMaxOcupantes;

}