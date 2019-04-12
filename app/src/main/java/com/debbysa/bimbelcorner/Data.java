package com.debbysa.bimbelcorner;

import android.provider.ContactsContract;

import com.debbysa.bimbelcorner.models.User;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<User> users;

    static {
            users = new ArrayList<>();
            users.add(new User("adi", "rahasia"));
            users.add(new User("beni", "rahasia"));
            users.add(new User("cindy", "rahasia"));

        }

    public static List<User> getUsers() {
        return users;
    }

}
