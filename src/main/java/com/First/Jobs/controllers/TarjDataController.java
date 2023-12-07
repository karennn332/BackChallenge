package com.First.Jobs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.First.Jobs.Service.TarjetaDataService;
import com.First.Jobs.models.TarjetaData;

@RestController
@RequestMapping("/api/charData")
public class TarjDataController {
	private TarjetaDataService chartDataService;

    public TarjDataController(TarjetaDataService chartDataService) {
        this.chartDataService = chartDataService;
    }

    @GetMapping
    public ResponseEntity<List<TarjetaData>> getChartData() {
        List<TarjetaData> chartData = chartDataService.getAllChartData();
        return ResponseEntity.status(HttpStatus.OK).body(chartData);
    }

    @PostMapping
    public ResponseEntity<TarjetaData> createChartData(@RequestBody @Valid TarjetaData chartData) {
        TarjetaData createdChartData = chartDataService.createChartData(chartData);
        return ResponseEntity.status(HttpStatus.OK).body(createdChartData);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la solicitud");
    }

}
