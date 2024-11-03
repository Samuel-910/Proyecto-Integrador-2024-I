package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Convocatoria;
import com.example.mscoordinador.repository.ConvocatoriaRepository;
import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.service.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {
    @Autowired
    ConvocatoriaRepository convocatoriaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Override
    public List<Convocatoria> listar() {
        return convocatoriaRepository.findAll();
    }

    @Override
    public Convocatoria guardar(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    @Override
    public Convocatoria buscarPorId(Integer id) {
        return convocatoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Convocatoria actualizar(Integer id,Convocatoria convocatoria) {
        Convocatoria convocatoriaFromDb = convocatoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convocatoria no encontrada con id: " + id));
        convocatoriaFromDb.setTitulo(convocatoria.getTitulo());
        convocatoriaFromDb.setDescripcion(convocatoria.getDescripcion());
        convocatoriaFromDb.setExperiencia(convocatoria.getExperiencia());
        convocatoriaFromDb.setFechaInicio(convocatoria.getFechaInicio());
        convocatoriaFromDb.setFechaFin(convocatoria.getFechaFin());
        convocatoriaFromDb.setFormaAca(convocatoria.getFormaAca());
        convocatoriaFromDb.setIdiomas(convocatoria.getIdiomas());
        convocatoriaFromDb.setPuesto(convocatoria.getPuesto());
        convocatoriaFromDb.setSalario(convocatoria.getSalario());
        convocatoriaFromDb.setVacantes(convocatoria.getVacantes());
        convocatoriaFromDb.setEstado(convocatoria.getEstado());
        convocatoriaFromDb.setEmpresa(convocatoria.getEmpresa());
        return convocatoriaRepository.save(convocatoriaFromDb);
    }

    @Override
    public void eliminar(Integer id) {
        convocatoriaRepository.deleteById(id);

    }

    @Override
    public Convocatoria decrementarVacante(Integer id) {
        Convocatoria convocatoria = convocatoriaRepository.findById(id).orElse(null);
        // Decrementar la vacante
        int vacantesActuales = convocatoria.getVacantes();
        if (vacantesActuales > 0) {
            convocatoria.setVacantes(vacantesActuales - 1);
        } else {
            throw new RuntimeException("No hay vacantes disponibles para la convocatoria");
        }

        return convocatoriaRepository.save(convocatoria);
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?") // Se ejecuta todos los días a medianoche
    public void actualizarEstadoConvocatorias() {
        List<Convocatoria> convocatorias = convocatoriaRepository.findAll();

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato adecuado para tus fechas

        for (Convocatoria convocatoria : convocatorias) {
            try {
                LocalDate fechaFin = LocalDate.parse(convocatoria.getFechaFin(), formatter);
                if (fechaFin.isBefore(fechaActual) && convocatoria.getEstado().equals("Activo")) {
                    convocatoria.setEstado("Inactivo");
                    convocatoriaRepository.save(convocatoria);
                }
            } catch (DateTimeParseException e) {
                System.err.println("Error al parsear la fecha para la convocatoria con id: " + convocatoria.getId());
            }
        }
    }
}
