package com.konar.aopdemo;

import com.konar.aopdemo.dao.AccountDao;
import com.konar.aopdemo.dao.MembershipDao;
import com.konar.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AccountDao accountDao,
            MembershipDao membershipDao,
            TrafficFortuneService trafficFortuneService
    ) {
        return runner -> {
//            demoTheBeforeAdvice(accountDao, membershipDao);

//            demoTheAfterReturnAdvice(accountDao);

//            demoTheAfterThrowingAdvice(accountDao);

//            demoTheAfterAdvice(accountDao);
            
//            demoTheAroundAdvice(trafficFortuneService);

//            demoTheAroundAdviceHandleException(trafficFortuneService);
            demoTheAroundAdviceRethrowException(trafficFortuneService);


        };
    }

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
        boolean tripWire = true;

        System.out.println("\nMain Program : demoTheAroundAdvice");
        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune(tripWire);

        System.out.println("\nFortune is : " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

        boolean tripWire = true;

        System.out.println("\nMain Program : demoTheAroundAdvice");
        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune(tripWire);

        System.out.println("\nFortune is : " + data);
        System.out.println("Finished");

    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

        System.out.println("\nMain Program : demoTheAroundAdvice");
        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nFortune is : " + data);
        System.out.println("Finished");

    }

    private void demoTheAfterAdvice(AccountDao accountDao) {
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDao.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program : ... caught exception " + exc);
        }
        System.out.println("\n\nMain Program : demoTheAfterAdvice");
        System.out.println("-------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDao.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program : ... caught exception " + exc);
        }
        System.out.println("\n\nMain Program : demoTheAfterThrowingAdvice");
        System.out.println("-------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturnAdvice(AccountDao accountDao) {

        List<Account> accounts = accountDao.findAccounts();

        System.out.println("\n\nMain Program : demoTheAfterReturnAdvice");
        System.out.println("-------");
        System.out.println(accounts);
        System.out.println("\n");

    }

    private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {

        Account account = new Account();

        account.setName("John");
        account.setLevel("One");

        accountDao.addAccount(account, true);
        accountDao.doWork();
        accountDao.getName();
        accountDao.setName("Alex");
        accountDao.getAccountService();
        accountDao.setAccountService("No Service");

        membershipDao.addAccount();
        membershipDao.goToSleep();

    }

}
