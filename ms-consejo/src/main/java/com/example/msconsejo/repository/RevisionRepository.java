package com.example.msconsejo.repository;

import com.example.msconsejo.entity.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision,Integer> {
}
