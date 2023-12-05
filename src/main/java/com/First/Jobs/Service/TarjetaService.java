package com.First.Jobs.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.First.Jobs.Dtos.UpdateBalanceDto;
import com.First.Jobs.models.Tarjeta;
import com.First.Jobs.repositories.TarjetaRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TarjetaService {
	
	private TarjetaRepo tarjetaRepo;

    public TarjetaService(TarjetaRepo TarjetaRepo) {
        this.tarjetaRepo = TarjetaRepo;
    }

    public List<Tarjeta> getAllCards() {
        return tarjetaRepo.findAll();
    }

    public Tarjeta saveCard(Tarjeta tarjeta) {
        if (isValidCardNumber(tarjeta.getNumeroTarjeta())) {
            return tarjetaRepo.save(tarjeta);
        } else {
            throw new IllegalArgumentException("El número de tarjeta no es válido");
        }
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d+");
    }

    public Tarjeta updateBalance(UpdateBalanceDto updateBalanceDTO) {
        Tarjeta tarjeta = tarjetaRepo.findById(updateBalanceDTO.getCardId())
                .orElseThrow(() -> new EntityNotFoundException("Tarjeta no encontrada"));
        tarjeta.setBalance(updateBalanceDTO.getNewBalance());
        return tarjetaRepo.save(tarjeta);
    }

}
