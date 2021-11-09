package com.back.futbol.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import com.back.futbol.exceptions.CustomException;
import com.back.futbol.models.EquipoModel;
import com.back.futbol.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @PostMapping("/equipos")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody EquipoModel equipo,Errors error){
        if(error.hasErrors()){
            throwError(error);
        }

        this.equipoService.guardarEquipo(equipo);
        Map<String, String> response= new HashMap<>();
        response.put("mensaje","El equipo se agrego correctamente");
        return ResponseEntity.ok(response);
    }

    //metodo para traer informacion
    @GetMapping("/equipos")
    public List<EquipoModel> traerTodos(){
        return this.equipoService.obtenerEquipos();
    }

    //metodo de obtener datos por id
    @GetMapping("/equipos/{id}") //toma el valor del pad {id} y se lo asigna la variable ""String id"
    public EquipoModel buscarID(@PathVariable String id) { // y esta variable pasa al metodo buscarPorId
        return this.equipoService.buscarPorId(id).get();   //el cual esta en el modulo EquipoService
    }

    private void throwError(Errors error) {

        String message="";
        int index=0;
        for(ObjectError e: error.getAllErrors()){ //mapeo de los diferentes errores que se presenten
            if(index>0){
                message += "  ";
            }
                            //format me permite, con el %s colocar valores dentro de String, utilizando las comas, uno despues del otro
            message += String.format("parametro: %s - Mensaje: %s", e.getObjectName(),e.getDefaultMessage());
                                                                      //parametro            mensaje
        }
        throw new CustomException(message); //utilizacion de la clase CustomException
    }


    
}


//     .\mvnw.cmd spring-boot:run