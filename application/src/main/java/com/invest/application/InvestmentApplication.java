package com.invest.application;

import com.invest.advicer.domain.AdviceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages = "com.invest")
@EnableJpaRepositories(
        basePackages = "com.invest")
@EntityScan(basePackages= {"com.invest"})
@EnableScheduling
public class InvestmentApplication {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {

        applicationContext = SpringApplication.run(InvestmentApplication.class, args);

        AdviceService adviceService = (AdviceService) applicationContext.getBean("adviceService");
        adviceService.getAdvice("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b");
        //displayAllBeans();

    }

    public static void displayAllBeans() {
       String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
           System.out.println(beanName);
        }
    }

}

