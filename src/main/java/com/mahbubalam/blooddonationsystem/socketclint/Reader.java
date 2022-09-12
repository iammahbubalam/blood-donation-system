package com.mahbubalam.blooddonationsystem.socketclint;

import com.mahbubalam.blooddonationsystem.NotificationController;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;

public class Reader implements Runnable {
    NetworkUtility networkUtility;
    public Reader(NetworkUtility networkUtility, NotificationController notificationController) {
        this.networkUtility=networkUtility;
    }


    @Override
    public void run() {
        while(true){
            String msg;
            System.out.println(1);
            Object object=networkUtility.read();

            msg = (String) object;
            System.out.println("msg = " + msg);

        }
    }
}
