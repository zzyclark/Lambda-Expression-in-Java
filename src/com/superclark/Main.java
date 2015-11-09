package com.superclark;

import com.superclark.Service.CheckUser;
import com.superclark.Service.impl.CheckAdultUserPredicator;
import com.superclark.Service.impl.CheckAdultUserService;
import com.superclark.Service.impl.NameDataConsumer;
import com.superclark.Service.impl.UserNameMapper;
import com.superclark.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    /**
     * Data constructor
     * @return
     */
    private static List<User> dataConstruct() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Clark", "Address 1", 25));
        userList.add(new User("David", "Address 2", 47));
        userList.add(new User("Bob", "Address 3", 13));

        return userList;
    }

    /**
     * find all user older than 18
     * @param users
     * @param checker
     */
    private static void findAdultUser(List<User> users, CheckUser checker) {
        for (User u : users) {
            if (checker.check(u)) {
                System.out.println(u.toString());
            }
        }
    }

    /**
     * find all user older than 18 and only print out their name
     *
     * 1. filter user list to grab matched user,
     * 2. grab name data from each user for future process,
     * 3. consume name data.
     *
     * @param users
     * @param predicator
     * @param mapper
     * @param consumer
     */
    private static void findAdultUserName(List<User> users,
                                          Predicate<User> predicator,
                                          Function<User, String> mapper,
                                          Consumer<String> consumer) {
        for (User u : users) {
            if (predicator.test(u)) {
                String s = mapper.apply(u);
                consumer.accept(s);
            }
        }
    }

    public static void main(String[] args) {
        List<User> userList = dataConstruct();

        /**
         * Normal age filter give filtered user list,
         * this will print all user information match filter.
         * findAdultUser() give us rough data of the filtered list.
         */
        findAdultUser(userList, new CheckAdultUserService());

        /**
         * More concrete work flow to handle user list.
         */
        findAdultUserName(userList,
                new CheckAdultUserPredicator(),
                new UserNameMapper(),
                new NameDataConsumer());

        /**
         * A Lambda Expression approach for findAdultUserName()
         */
        findAdultUserName(userList,
                u -> u.getAge() > 18, //same as the predicator
                u -> u.getName(),     //same as the mapper
                name -> System.out.println(name));  //same as the consumer

        /**
         * Aggregate Operation approach with Lambda Expression for findAdultUserName()
         */
        userList.stream()
                .filter(u -> u.getAge() > 18)
                .map(u -> u.getName())
                .forEach(name -> System.out.println(name));
    }
}
