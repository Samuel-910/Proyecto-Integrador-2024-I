package com.example.mssupervisor.repository;

import com.example.mssupervisor.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor,Integer> {
}
