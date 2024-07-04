package com.konar.aopdemo.dao;


import com.konar.aopdemo.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAccounts();

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    String getAccountService();

    void setName(String name);

    void setAccountService(String accountService);


    List<Account> findAccounts(boolean tripWire);
}
