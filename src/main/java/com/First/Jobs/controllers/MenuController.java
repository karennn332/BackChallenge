package com.First.Jobs.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.First.Jobs.Service.ItemMenuService;
import com.First.Jobs.models.ItemMenu;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

	
	private ItemMenuService menuService;

    public MenuController(ItemMenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<ItemMenu> getMenuItems() {
        return menuService.getMenuItems();
    }

    @PostMapping
    public ResponseEntity<ItemMenu> createMenuItem(@RequestBody ItemMenu menuItem) {
        ItemMenu savedMenuItem = menuService.saveMenuItem(menuItem);
        return new ResponseEntity<>(savedMenuItem, HttpStatus.CREATED);
    }
}
