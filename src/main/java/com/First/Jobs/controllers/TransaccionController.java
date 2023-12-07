package com.First.Jobs.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.First.Jobs.Service.TransaccionService;
import com.First.Jobs.models.Transaccion;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

	   private final TransaccionService transaccionService;

	    public TransaccionController(TransaccionService transactionService) {
	        this.transaccionService = transactionService;
	    }

	    @GetMapping
	    public List<Transaccion> getAllTransactions() {
	        return transaccionService.getAllTransactions();
	    }

	    @PostMapping
	    public ResponseEntity<Transaccion> createTransaction(@Valid @RequestBody Transaccion transaction) {
	        Transaccion savedTransaction = transaccionService.saveTransaction(transaction);
	        return ResponseEntity.created(URI.create("/api/transaccions/" + savedTransaction.getId()))
	                .body(savedTransaction);
	    }
}
