package com.invest.portfolio.service;

import com.invest.portfolio.domain.*;
import com.invest.portfolio.infrastructure.InMemoryPortfolioRepository;
import com.invest.portfolio.infrastructure.PortfolioRepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PortfolioModificationService {

    private Logger logger = LoggerFactory.getLogger(PortfolioModificationService.class);

    private PortfolioRepository portfolioRepository;

    public PortfolioModificationService() {
        this.portfolioRepository = new InMemoryPortfolioRepository();
    }


//    @Autowired
//    public PortfolioModificationService(PortfolioRepository portfolioRepository) {
//        this.portfolioRepository = portfolioRepository;
//    }

    public String test() {
        return "Тест пройден!";
    }

    public String createPortfolio(String name, Long targetAmount, LocalDateTime horizont, String mainPortfolioId) throws PortfolioModificationServiceException {
        try {
            if (name == null || name.isEmpty()) {
                throw new PortfolioModificationServiceException("Наименование портфеля не указано!");
            }
            if (targetAmount == null || targetAmount <= 0L) {
                throw new PortfolioModificationServiceException("Не задана целевая сумма портфеля!");
            }
            if (horizont == null || horizont.isBefore(LocalDateTime.now())) {
                throw new PortfolioModificationServiceException("Не корректно указан горизонт инвестирования!");
            }
            Portfolio portfolio = Portfolio.create(name, targetAmount, horizont, mainPortfolioId);
            portfolioRepository.save(portfolio);
            return portfolio.id();
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }

    public String addCriterion(String name, String distribution, String mainCriteriaId, int priority) throws PortfolioModificationServiceException {
        try {
            if (name == null || name.isEmpty()) {
                throw new PortfolioModificationServiceException("Наименование критерия распределения не указано!");
            }
            if (distribution == null || distribution.isEmpty()) {
                throw new PortfolioModificationServiceException("Наименование типа распределения не указано!");
            }
            Criteria criteria = Criteria.create(name, distribution, mainCriteriaId, priority);
            portfolioRepository.add(criteria);
            return criteria.getId();
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }

    public String addDistributionToPortfolio(String portfolioId, String criteriaId, int perCent) throws PortfolioModificationServiceException {
        try {
            if (portfolioId == null || portfolioId.isEmpty()) {
                throw new PortfolioModificationServiceException("Не задан идентификатор портфеля!");
            }
            if (criteriaId == null || criteriaId.isEmpty()) {
                throw new PortfolioModificationServiceException("Не задан идентификатор критерия распределения!");
            }
            if (perCent <= 0) {
                throw new PortfolioModificationServiceException("Не задан процент распределения!");
            }

            // доп проверка, что есть портфель с таким id и критерий с таким id!!!
            // а то черти что добавляется

            PortfolioDistribution distribution = PortfolioDistribution.create(portfolioId,criteriaId, perCent);
            portfolioRepository.apply(distribution);
            return distribution.getId();
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }

    public List<PortfolioDistributionResult> checkPortfolioDistribution(String portfolioId) throws PortfolioModificationServiceException {
        try {
            if (portfolioId == null || portfolioId.isEmpty()) {
                throw new PortfolioModificationServiceException("Не задан идентификатор портфеля!");
            }
            return portfolioRepository.getDistributionForPortfolio(portfolioId);
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }

    private List<Criteria> getCriteriaForDistributionLevel(Distribution distribution) throws PortfolioModificationServiceException {
        try {
            return portfolioRepository.getCriteriaForDistribution(distribution);
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }

    private List<Criteria> getChildCriteriaForParent(String mainCriterionId) throws PortfolioModificationServiceException {
        try {
            return portfolioRepository.getChildCriteriaForParent(mainCriterionId);
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }

    private Distribution getDistributionOfLevel(int level) {
        return Distribution.getDistributionLevels(level);
    }

    public int portfolioDistributionLevelsAmount(String portfolioId) {
        return 3; // тут пока заглушка
    }

    public List<PortfolioDistributionResult> portfolioDistributionOfLevel(String portfolioId, int level) throws PortfolioModificationServiceException {
        try {
            Distribution distribution = getDistributionOfLevel(level);
            List<Criteria> criteria = getCriteriaForDistributionLevel(distribution);
            return portfolioRepository.getPortfolioDistributionWithCriteria(portfolioId, criteria);
        } catch (PortfolioRepositoryException e) {
            logger.error(e.getMessage());
            throw new PortfolioModificationServiceException(e);
        }
    }
}
