package com.example.mspracticante.repository;

import com.example.mspracticante.entity.Practicante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticanteRepository extends JpaRepository<Practicante,Integer> {
    Practicante findByAuth(int auth);
}
