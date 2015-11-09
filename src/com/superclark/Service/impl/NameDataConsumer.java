package com.superclark.Service.impl;

import java.util.function.Consumer;

/**
 * @Author clark
 * @Date 09-Nov-2015
 */
public class NameDataConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
