package com.First.Jobs.repositories;

import java.awt.MenuItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long>{

}
