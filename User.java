package com.company;

import java.util.ArrayList;
import java.util.List;

public class User {

    public boolean isUsed;
    public int userNumber;
    public int requestsCount;

    // list of resources to use
    List<Resource> userRequestList;
    // time taken per resource

    public User(int number, int requests){
        userNumber = number;
        requestsCount = requests;
    }
}
