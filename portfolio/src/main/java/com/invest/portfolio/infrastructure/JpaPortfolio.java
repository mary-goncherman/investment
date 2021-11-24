package com.invest.portfolio.infrastructure;

import com.invest.portfolio.domain.Portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "portfolio")
public class JpaPortfolio {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "target_amount")
    private long targetAmount;

    @Column(name = "horizont")
    private LocalDateTime horizont;

    @Column(name = "main_portfolio_id")
    private String mainPortfolioId;

    private JpaPortfolio() {}

    private JpaPortfolio(String id, String name, long targetAmount, LocalDateTime horizont, String mainPortfolioId) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.horizont = horizont;
        this.mainPortfolioId = mainPortfolioId;
    }

    public static JpaPortfolio createFrom(Portfolio portfolio) {
        return new JpaPortfolio(
                portfolio.id(),
                portfolio.getName(),
                portfolio.getTargetAmount(),
                portfolio.getHorizon(),
                portfolio.getMainPortfolioId());
    }

    public static Portfolio buildPortfolioFrom(JpaPortfolio jpaPortfolio) {
        return Portfolio.build(jpaPortfolio.id, jpaPortfolio.name, jpaPortfolio.targetAmount, jpaPortfolio.horizont, jpaPortfolio.mainPortfolioId);
    }

    @Override
    public String toString() {
            return "JPAPortfolio " + id + " " + name + " " + targetAmount + " " + horizont + " " + mainPortfolioId;

    }
}
