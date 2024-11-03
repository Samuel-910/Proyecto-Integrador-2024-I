package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Convocatoria;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface ConvocatoriaService {
    public List<Convocatoria> listar();

    public Convocatoria guardar(Convocatoria convocatoria);

    public Convocatoria buscarPorId(Integer id);

    public Convocatoria actualizar(Integer id, Convocatoria convocatoria);

    public void eliminar(Integer id);
    public Convocatoria decrementarVacante(Integer id);

    @Scheduled(cron = "0 0 0 * * ?") // Se ejecuta todos los días a medianoche
    void actualizarEstadoConvocatorias();
}
