package com.First.Jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.First.Jobs.models.Tarjeta;


@Repository
public interface TarjetaRepo extends JpaRepository<Tarjeta, Long> {

}
