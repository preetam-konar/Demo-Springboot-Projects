package com.konar.aopdemo.dao;


import com.konar.aopdemo.Account;

public interface AccountDao {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

}
