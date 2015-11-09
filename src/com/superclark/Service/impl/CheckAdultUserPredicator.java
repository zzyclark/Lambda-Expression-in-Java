package com.superclark.Service.impl;

import com.superclark.model.User;

import java.util.function.Predicate;

/**
 * @Author clark
 * @Date 09-Nov-2015
 */
public class CheckAdultUserPredicator implements Predicate<User> {
    @Override
    public boolean test(User user) {
        return user.getAge() > 18;
    }
}
