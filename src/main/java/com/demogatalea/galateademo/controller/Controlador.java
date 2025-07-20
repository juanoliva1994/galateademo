package com.demogatalea.galateademo.controller;
import com.demogatalea.galateademo.model.Modelo;
import com.demogatalea.galateademo.service.LogicaPrueba;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clue")
public class Controlador {
        @PostMapping("/")
        public ResponseEntity<String> crearColeccion(@RequestBody Modelo request) {
            boolean validacion = LogicaPrueba.validacionPalabraClave(
                    request.getManuscript().toArray(new String[0])
            );
            if (validacion) {
                return ResponseEntity.ok("Palabra clave encontrada");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("palabra clave no encontrada");
            }
        }
    }
