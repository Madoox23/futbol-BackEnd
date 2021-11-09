package com.back.futbol.services;

import java.util.List;
import java.util.Optional;

import com.back.futbol.models.EquipoModel;
import com.back.futbol.repositories.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {

    @Autowired
    EquipoRepository equipoRepository;

    public void guardarEquipo(EquipoModel equipo){ //metodo guardar
        this.equipoRepository.save(equipo);
    }

    public List<EquipoModel> obtenerEquipos(){ //traer lista de equipos
        return this.equipoRepository.findAll();
    }

    public Boolean existById(String id){ // ver si existe
        return this.equipoRepository.existsById(id);
    }

    public Optional<EquipoModel> buscarPorId(String id){ //buscar por id
        return this.equipoRepository.findById(id);
    }

    public void eliminarPorId(String id){ //eliminar por id
        this.equipoRepository.deleteById(id);
    }
    
}
