package com.First.Jobs.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.First.Jobs.models.ItemMenu;

@Repository
public interface MenuItemRepo extends JpaRepository<ItemMenu, Long>{

}
