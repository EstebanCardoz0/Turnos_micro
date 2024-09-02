package org.example.turnos_micro.controller;

import org.example.turnos_micro.entity.Turno;
import org.example.turnos_micro.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController @RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

    @PostMapping("/crear")
    public String crearTurno(@RequestBody
                             LocalDate fecha,
                             @RequestBody
                             String tratamiento,
                             @RequestBody
                             String dniPaciente) {
        turnoServ.saveTurno(fecha, tratamiento,
                dniPaciente);
        return "Turno creado con éxito";
    }

    @GetMapping("/traer/{id}")
    public Turno traerTurno(
            @PathVariable Long id) {
        return turnoServ.findTurno(id);
    }

    @GetMapping("/traer")
    public List<Turno> traerTurnos() {
        return turnoServ.getTurnos();
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(
            @PathVariable Long id) {
        turnoServ.deleteTurno(id);
        return "Turno borrado con éxito";
    }

    @PutMapping("/editar/{id}")
    public Turno editTurno(
            @RequestBody Turno tur,
            @PathVariable Long id) {
        turnoServ.editTurno(tur, id);

        return turnoServ.findTurno(
                id);

    }


}
