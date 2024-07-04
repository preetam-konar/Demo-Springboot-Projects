package com.konar.aopdemo.dao;

import com.konar.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

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
