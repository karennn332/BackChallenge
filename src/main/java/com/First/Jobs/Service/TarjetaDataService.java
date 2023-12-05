package com.First.Jobs.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.First.Jobs.models.TarjetaData;
import com.First.Jobs.repositories.TarjDataRepo;

@Service
public class TarjetaDataService {

	

	 private TarjDataRepo chartDataRepository;

	    public TarjetaDataService(TarjDataRepo chartDataRepository) {
	        this.chartDataRepository = chartDataRepository;
	    }

	    public List<TarjetaData> getAllChartData() {
	        return chartDataRepository.findAll();
	    }

	    public TarjetaData createChartData(TarjetaData chartData) {
	        return chartDataRepository.save(chartData);
	    }
}
