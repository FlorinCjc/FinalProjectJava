package com.onlineshop.comonlineshop.repositories;

import com.onlineshop.comonlineshop.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command, Integer> {
}
