package com.First.Jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.First.Jobs.models.TarjetaData;

@Repository
public interface TarjDataRepo extends JpaRepository<TarjetaData, Long> {

}
