package com.invest.controller.analitics;

import com.invest.analitics.service.AnaliticServiceException;
import com.invest.analitics.service.PortfolioAnaliticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analisys")
public class AnaliseResource {

    @Autowired
    public PortfolioAnaliticService analiticService;

    @GetMapping("/month/turnover")
    public ResponseEntity<Object> getTurnover() {
        try {
            return ResponseEntity.ok()
                    .body(analiticService.getTurnoverByMonths());
        } catch (AnaliticServiceException e) {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/average/buy/price")
    public ResponseEntity<Object> getAverageBuyPrice() {
        try {
            return ResponseEntity.ok()
                    .body(analiticService.getAverageBuyPrice());
        } catch (AnaliticServiceException e) {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/asset/allocation")
    public ResponseEntity<Object> getAssetAllocation() {
        try {
            return ResponseEntity.ok()
                    .body(analiticService.getAssetAllocation());
        } catch (AnaliticServiceException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/industry/allocation")
    public ResponseEntity<Object> getIndustryAllocation() {
        try {
            return ResponseEntity.ok()
                    .body(analiticService.getIndustryAllocation());
        } catch (AnaliticServiceException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/country/allocation")
    public ResponseEntity<Object> getCountryAllocation() {
        try {
            return ResponseEntity.ok()
                    .body(analiticService.getCountryAllocation());
        } catch (AnaliticServiceException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
