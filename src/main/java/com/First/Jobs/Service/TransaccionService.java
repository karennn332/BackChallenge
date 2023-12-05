package com.First.Jobs.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.First.Jobs.models.Transaccion;
import com.First.Jobs.repositories.TransaccionRepo;

@Service
public class TransaccionService {
	
	private final TransaccionRepo transaccionRepo;

    public TransaccionService(TransaccionRepo transaccionRepo) {
        this.transaccionRepo = transaccionRepo;
    }

    public List<Transaccion> getAllTransactions() {
        return transaccionRepo.findAll();
    }

    public Transaccion getTransactionById(Long id) {
        return transaccionRepo.findById(id).orElse(null);
    }

    public Transaccion saveTransaction(Transaccion transaction) {
        return transaccionRepo.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transaccionRepo.deleteById(id);
    }

}
