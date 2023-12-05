package com.First.Jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.First.Jobs.models.Transaccion;

@Repository
public interface TransaccionRepo extends JpaRepository<Transaccion, Long> {

}
