//creacion del crud del equipo, donde podamos agregar, modificar, traer y eliminar//

package com.back.futbol.models;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.*;


@Document(collection ="equipos") //creacion de un documento dentro de la collection equipos, collection es equivalente a la tabla
public class EquipoModel {       //el documento va a ser cada uno de los registros

    @Id                         //definir este campo como id
    private String id;

    @NotEmpty(message="El nombre del equipo no puede estar vacio") //este campo no puede estar vacio, si lo esta envia un mensaje
    private String nombre;

    public String getId() { //metodo selector del id
        return id;
    }

    public void setId(String id) { //modificador del id
        this.id = id;
    }

    public String getNombre() { //selector del nombre
        return nombre;
    }
 
    public void setNombre(String nombre) { //modificador del nombre
        this.nombre = nombre;
    }

}
