package com.invest.controller.portfolio;


import com.invest.portfolio.service.PortfolioModificationService;
import com.invest.portfolio.service.PortfolioModificationServiceException;
import com.invest.portfolio.domain.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criteria")
public class CriteriaResource {

        private Logger logger = LoggerFactory.getLogger(CriteriaResource.class);

        @Autowired
        public PortfolioModificationService portfolioService;

        @PostMapping("/add")
        public String add(@RequestBody Criteria criteria) {
            try {
                return portfolioService.addCriterion(
                        criteria.getName(),
                        criteria.getDistributionName(),
                        criteria.getMainCriteriaId(),
                        criteria.getPriority());
            } catch (PortfolioModificationServiceException e) {
                return null;
            }
        }
    }