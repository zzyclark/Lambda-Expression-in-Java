package com.superclark.Service.impl;

import com.superclark.model.User;

import java.util.function.Function;

/**
 * @Author clark
 * @Date 09-Nov-2015
 */
public class UserNameMapper implements Function<User, String>{
    @Override
    public String apply(User user) {
        return user.getName();
    }
}
