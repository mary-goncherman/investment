package com.invest.portfolio.infrastructure;

import com.invest.portfolio.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class JpaPortfolioRepository //implements PortfolioRepository
{

    private Logger logger = LoggerFactory.getLogger(JpaPortfolioRepository.class);

    @Autowired
    private EntityManager entityManager;

    //@Override
    public void save(Portfolio portfolio) throws PortfolioRepositoryException {
        try {
            JpaPortfolio jpaPortfolio = JpaPortfolio.createFrom(portfolio);
            entityManager.persist(jpaPortfolio);
        } catch (Exception e) {
            throw new PortfolioRepositoryException(e);
        }
    }

    //@Override
    public Portfolio findBy(String id) throws PortfolioRepositoryException {
        try {
            JpaPortfolio jpaPortfolio = entityManager.find(JpaPortfolio.class, id);
            return JpaPortfolio.buildPortfolioFrom(jpaPortfolio);
        } catch (Exception e) {
            throw new PortfolioRepositoryException(e);
        }
    }

    //@Override
    public void add(Criteria criteria) throws PortfolioRepositoryException {
        try {
            JpaCriteria jpaCriteria = JpaCriteria.createFrom(criteria);
            entityManager.persist(jpaCriteria);
        } catch (Exception e) {
            throw new PortfolioRepositoryException(e);
        }
    }

    //@Override
    public void apply(PortfolioDistribution portfolioDistribution) throws PortfolioRepositoryException {
        try {
            JpaDistribution jpaDistribution = JpaDistribution.createFrom(portfolioDistribution);
            logger.error(jpaDistribution.toString());
            entityManager.persist(jpaDistribution);
        } catch (Exception e) {
            throw new PortfolioRepositoryException(e);
        }
    }

    //@Override
    public List<PortfolioDistributionResult> getDistributionForPortfolio(String portfolioId) throws PortfolioRepositoryException {
        try {
            List<PortfolioDistributionResult> resultList = entityManager
                    .createQuery("SELECT distribution FROM PortfolioDistributionResult distribution WHERE distribution.portfolioId = :portfolioId and distribution.deleted = false",
                            PortfolioDistributionResult.class)
                    .setParameter("portfolioId", portfolioId)
                    .getResultList();
            if (resultList == null) {
                return new ArrayList<>();
            }
            return resultList;
        } catch (Exception e) {
            throw new PortfolioRepositoryException(e);
        }
    }


}
