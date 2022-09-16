package com.mahbubalam.blooddonationsystem.socketclint;

import com.mahbubalam.blooddonationsystem.UserProfileController;
import com.mahbubalam.blooddonationsystem.util.Data;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;

import java.util.Scanner;

public class Writer implements Runnable {
    NetworkUtility networkUtility;
    UserProfileController userProfileController;

    public Writer(NetworkUtility networkUtility, UserProfileController userProfileController) {
        this.networkUtility = networkUtility;
        this.userProfileController = userProfileController;
    }

    @Override
    public void run() {
        userProfileController.textArea.setText("hello");
        Data data = new Data();
        while (true) {
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
