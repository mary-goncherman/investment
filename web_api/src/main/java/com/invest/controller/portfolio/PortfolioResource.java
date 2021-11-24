package com.invest.controller.portfolio;

import com.invest.portfolio.domain.Portfolio;
import com.invest.portfolio.domain.PortfolioDistributionResult;
import com.invest.portfolio.service.PortfolioModificationService;
import com.invest.portfolio.service.PortfolioModificationServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioResource {

    private Logger logger = LoggerFactory.getLogger(PortfolioResource.class);

    @Autowired
    public PortfolioModificationService portfolioService;

    @GetMapping("/test")
    public String test() {
        return portfolioService.test();
    }

    @PostMapping("/create")
    public @ResponseBody ResponseEntity<String> create(@RequestBody Portfolio portfolio) {
        try {
            String portfolioId = portfolioService.createPortfolio(portfolio.getName(), portfolio.getTargetAmount(), portfolio.getHorizon(), portfolio.getMainPortfolioId());
            return new ResponseEntity<String>(portfolioId, HttpStatus.OK);
        } catch (PortfolioModificationServiceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{portfolioId}/add/distribution/by/criteria/{criteriaId}")
    public @ResponseBody ResponseEntity<String> addDistribution(@RequestParam int perCent, @PathVariable String portfolioId, @PathVariable String criteriaId) {
        try {
            portfolioService.addDistributionToPortfolio(portfolioId, criteriaId, perCent);
            return new ResponseEntity<String>("Критерий распределения активов успешно добавлен!", HttpStatus.OK);
        } catch (PortfolioModificationServiceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{portfolioId}/get/distribution")
    public @ResponseBody ResponseEntity getDistribution(@PathVariable String portfolioId) {
        try {
            List<PortfolioDistributionResult> result = portfolioService.checkPortfolioDistribution(portfolioId);
            return new ResponseEntity<List<PortfolioDistributionResult>>(result, HttpStatus.OK);
        } catch (PortfolioModificationServiceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

