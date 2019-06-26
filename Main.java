package com.company;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        // initialize RNG
        Random rand = new Random();

        // sleep factor in seconds
        long sleepSeconds = 1;

        int resourceCount = rand.nextInt(30) + 1;
        resourceCount = 5;

        List<Resource> resourceList = new ArrayList<Resource>(resourceCount);

        for(int i = 1; i <= resourceCount; i++){
            resourceList.add(new Resource(i));
        }



        int userCount = rand.nextInt(30) + 1;

        List<User> userList = new ArrayList<User>(userCount);

        for(int i = 1; i <= userCount; i++){
            userList.add(new User(i, rand.nextInt (resourceCount) + 1));

            List<Resource> tempList = new ArrayList<Resource>(resourceList);
            while(tempList.size() != userList.get(i-1).requestsCount){
                tempList.remove(rand.nextInt(tempList.size()));
            }

            userList.get(i-1).userRequestList = tempList;

            System.out.println( "USER " +  i + " requests to use " + userList.get(i-1).requestsCount + " Resources");
            for(int j = 0; j !=tempList.size(); j++){
                System.out.print(tempList.get(j).resourceNumber + ",");
            }
            System.out.println("");
        }



        System.out.println(resourceList.size() + " RESOURCES");
        System.out.println(userList.size() + " USERS");

        System.out.print("\nPress \"ENTER\" to run simulation");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();


        //SIMULATION LOOP
        TimeUnit.MILLISECONDS.sleep(1000);
        return;

    }
}
