package com.mahbubalam.blooddonationsystem.socketclint;

import com.mahbubalam.blooddonationsystem.NotificationController;
import com.mahbubalam.blooddonationsystem.util.Data;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;

import java.util.Scanner;

public class Writer implements Runnable {
    NetworkUtility networkUtility;
    NotificationController notificationController ;
    public Writer(NetworkUtility networkUtility, NotificationController notificationController) {
        this.networkUtility=networkUtility;
        this.notificationController=notificationController;
    }

    @Override
    public void run() {
        Data data=new Data();
        while(true){
            System.out.println(2);
            Scanner in=new Scanner(System.in);
            data.message=in.nextLine();
            try{
                networkUtility.write(data.clone());
            }
            catch(Exception ex){
                System.out.println("sending failed");
            }
        }
    }
}
