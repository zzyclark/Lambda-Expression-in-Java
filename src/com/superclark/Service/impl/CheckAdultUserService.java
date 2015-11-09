package com.superclark.Service.impl;

import com.superclark.Service.CheckUser;
import com.superclark.model.User;

/**
 * @Author clark
 * @Date 09-Nov-2015
 */
public class CheckAdultUserService implements CheckUser {
    @Override
    public boolean check(User user) {
        return user.getAge() > 18;
    }
}
