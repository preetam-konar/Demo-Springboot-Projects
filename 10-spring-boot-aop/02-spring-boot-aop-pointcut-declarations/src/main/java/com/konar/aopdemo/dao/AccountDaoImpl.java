package com.konar.aopdemo.dao;

import com.konar.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private String name;

    private String accountService;

    public String getName() {
        System.out.println(getClass() + " : in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in setName");
        this.name = name;
    }

    public String getAccountService() {
        System.out.println(getClass() + " : in getAccountService");
        return accountService;
    }

    public void setAccountService(String accountService) {
        System.out.println(getClass() + " : in setAccountService");
        this.accountService = accountService;
    }


    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Simulated Error!!");
        }

        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("joe", "silver");
        Account temp2 = new Account("jane", "gold");
        Account temp3 = new Account("luke", "platinum");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : Doing DB work : Adding account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }


}
