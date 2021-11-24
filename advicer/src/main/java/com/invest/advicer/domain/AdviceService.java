package com.invest.advicer.domain;

import com.invest.analitics.domain.AllocationResult;
import com.invest.analitics.service.AnaliticServiceException;
import com.invest.analitics.service.PortfolioAnaliticService;
import com.invest.portfolio.domain.PortfolioDistributionResult;
import com.invest.portfolio.service.PortfolioModificationService;
import com.invest.portfolio.service.PortfolioModificationServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AdviceService {

    public PortfolioModificationService portfolioModificationService;
    public PortfolioAnaliticService portfolioAnaliticService;

    public AdviceService() {}

    @Autowired
    public AdviceService(PortfolioModificationService portfolioModificationService, PortfolioAnaliticService portfolioAnaliticService) {
        this.portfolioModificationService = portfolioModificationService;
        this.portfolioAnaliticService = portfolioAnaliticService;
    }

    public void getAdvice(String portfolioId) {

        try {

            int levelsNumber = portfolioModificationService.portfolioDistributionLevelsAmount(portfolioId);
            System.out.println("Количество уровней расчета " + levelsNumber);

            // запросить у контекста портфеля распределение 1-го уровня критериев
            List<PortfolioDistributionResult> planPortfolioDistributionOfFirstLevel = portfolioModificationService.portfolioDistributionOfLevel(portfolioId, 1);
            System.out.println("Плановое портфельное распределение первого уровня " + planPortfolioDistributionOfFirstLevel.toString());

            planPortfolioDistributionOfFirstLevel.sort(Comparator.comparing(PortfolioDistributionResult::getCriterionPriority));
            System.out.println("Плановое портфельное распределение сортировка по приоритету " + planPortfolioDistributionOfFirstLevel.toString());
            // получить фактическое распределение из модуля аналитики
            // Мдаа, пока так)
            List<AllocationResult> realPortfolioDistributionOfFirstLevel = portfolioAnaliticService.getAssetAllocation();
            System.out.println("Фактическое распределение " + realPortfolioDistributionOfFirstLevel.toString());

            for (int i = 1; i <= levelsNumber; i++) {
                String criteriaName = planPortfolioDistributionOfFirstLevel.get(i-1).getCriteriaName();
                System.out.println("Проверка критерия " + criteriaName);

                double planDistributionPerCent = planPortfolioDistributionOfFirstLevel.get(i-1).getPerCent();
                System.out.println("Плановый процент " + planDistributionPerCent);

                Optional<AllocationResult> allocationResultOptional = realPortfolioDistributionOfFirstLevel.stream()
                        .filter(allocationResult -> allocationResult.getCriteria().equals(criteriaName))
                        .findAny();
                double realDistributionPerCent = 0;
                if (allocationResultOptional.isPresent()) {
                    realDistributionPerCent = allocationResultOptional.get().getPerCent();

                    System.out.println("Фактический процент " + realDistributionPerCent);

                    if (realDistributionPerCent < planDistributionPerCent) {
                        System.out.println("Необходимо произвести докупку в категории " + criteriaName);
                    }
                } else {
                    System.out.println("Что-от пошло не так");
                }
            }


        } catch (PortfolioModificationServiceException | AnaliticServiceException e) {
            e.printStackTrace();
        }


    }


}
