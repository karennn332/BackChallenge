package com.First.Jobs.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.First.Jobs.Service.TarjetaService;
import com.First.Jobs.models.Tarjeta;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

	
	 private TarjetaService cardService;

	    public TarjetaController(TarjetaService cardService) {
	        this.cardService = cardService;
	    }

	    @GetMapping
	    public List<Tarjeta> getAllCards() {
	        return cardService.getAllCards();
	    }

	    @PostMapping
	    public ResponseEntity<Tarjeta> createCard(@RequestBody Tarjeta card) {
	        Tarjeta savedCard = cardService.saveCard(card);
	        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
	    }
}
