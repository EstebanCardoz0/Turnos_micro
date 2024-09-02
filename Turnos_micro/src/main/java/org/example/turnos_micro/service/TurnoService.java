package org.example.turnos_micro.service;

import org.example.turnos_micro.entity.Paciente;
import org.example.turnos_micro.entity.Turno;
import org.example.turnos_micro.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService
        implements ITurnoService {
    @Autowired
    private ITurnoRepository turnoRepo;

    @Autowired
    private RestTemplate apiConsumir;


    @Override public void saveTurno(
            LocalDate fecha,
            String tratamiento,
            String dniPaciente) {
        Paciente pac= apiConsumir.getForObject(
                "http://localhost:9001/paciente" +
                        "/traerdni/"+dniPaciente,
                Paciente.class);
//        String nombreCompletoPaciente =
        Turno tur = new Turno();
        tur.setFecha(fecha);
//        tur.setNombreCompletoPaciente();
        turnoRepo.save(tur);
    }

    @Override public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override public Turno findTurno(Long id) {
        return turnoRepo.findById(id)
                .orElse(null);
    }

    @Override public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override public void editTurno(Turno tur,
                                    Long id) {
        Turno turno = this.findTurno(id);
        turno.setFecha(tur.getFecha());
        turno.setTratamiento(
                tur.getTratamiento());
        turno.setNombreCompletoPaciente(
                tur.getNombreCompletoPaciente());
        turnoRepo.save(turno);
    }
}
