package com.example.msconsejo.repository;

import com.example.msconsejo.entity.ConsejoEP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsejoRepository extends JpaRepository<ConsejoEP,Integer> {
}
