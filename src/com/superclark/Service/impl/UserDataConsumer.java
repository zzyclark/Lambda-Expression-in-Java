package com.superclark.Service.impl;

import com.superclark.model.User;

import java.util.function.Consumer;

/**
 * @Author clark
 * @Date 09-Nov-2015
 */
public class UserDataConsumer implements Consumer<User> {
    @Override
    public void accept(User user) {
        user.printUser();
    }
}
