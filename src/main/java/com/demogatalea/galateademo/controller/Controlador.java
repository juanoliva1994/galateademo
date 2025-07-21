package com.demogatalea.galateademo.controller;
import com.demogatalea.galateademo.model.Modelo;
import com.demogatalea.galateademo.repository.ManuscriptRepository;
import com.demogatalea.galateademo.service.LogicaPrueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/clue")
public class Controlador {

    @Autowired
    private ManuscriptRepository repository;

    @PostMapping("/")
    public ResponseEntity<String> crearColeccion(@RequestBody Modelo request) {
        List<String> manuscript = request.getManuscript();
        boolean validacion = LogicaPrueba.validacionPalabraClave(
                request.getManuscript().toArray(new String[0])
        );

        if (!repository.existsByManuscript(manuscript)) {
            repository.save(new Modelo(manuscript, validacion));
        }

        if (validacion) {
            return ResponseEntity.ok("Palabra clave encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("palabra clave no encontrada");
        }
    }


    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        long clueFound = repository.findAll().stream().filter(Modelo::isClueFound).count();
        long noClue = repository.count() - clueFound;

        Map<String, Object> stats = new HashMap<>();
        stats.put("count_clue_found", clueFound);
        stats.put("count_no_clue", noClue);
        stats.put("ratio", noClue == 0 ? 1.0 : (double) clueFound / (clueFound + noClue));

        return ResponseEntity.ok(stats);
    }
}
