package com.First.Jobs.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.First.Jobs.models.ItemMenu;
import com.First.Jobs.repositories.MenuItemRepo;

@Service
public class ItemMenuService {

	private MenuItemRepo menuItemRepository;

	
	 public ItemMenuService(MenuItemRepo menuItemRepository) {
	        this.menuItemRepository = menuItemRepository;
	    }

	    public List<ItemMenu> getMenuItems() {
	        return menuItemRepository.findAll();
	    }

	    public ItemMenu saveMenuItem(ItemMenu menuItem) {
	        return menuItemRepository.save(menuItem);
	    }
	 

	  

   
}
