package com.konar.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

    @Override
    public boolean addAccount() {
        System.out.println(getClass() + " : Doing DB work : Adding Membership account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : goToSleep()");
    }
}
