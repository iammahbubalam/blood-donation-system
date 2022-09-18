package com.mahbubalam.blooddonationsystem.socketclint;

import com.mahbubalam.blooddonationsystem.UserProfileController;
import com.mahbubalam.blooddonationsystem.singletron.User;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;

public class Reader implements Runnable {
    NetworkUtility networkUtility;
    UserProfileController userProfileController;
    User user = User.getInstance();

    public Reader(NetworkUtility networkUtility, UserProfileController userProfileController) {
        this.networkUtility = networkUtility;
        this.userProfileController = userProfileController;
    }

    //    words[0] = Sender Id
//    words[1] = Receiver Id
//    words[2] = Sender Name
//    words[3] = keyword
//    words[4] = message/null
    @Override
    public void run() {
        while (true) {
            String actualMessage = (String) networkUtility.read();
            System.out.println(actualMessage);
            String[] words = actualMessage.split("\\$");
            if (words[2].equals("text")) {
                userProfileController.textArea.appendText("\n"+words[1] + " Says " + words[3]+"\n");
            }
            if (words[2].equals("requestForBlood")) {
                user.setMessage(actualMessage);
                userProfileController.textArea.appendText("\n"+words[1] + " sent you a request for donation on " + words[3]+"\n");
            }
            if (words[2].equals("donateBlood")) {
                userProfileController.textArea.appendText("\n"+words[1] + " Want to donate you blood "+"\n");
            }
            if (words[3].equals("accepted")) {
                String msgToSend = words[1] + "  Accepted your request";
                userProfileController.textArea.appendText("\n"+msgToSend);
            }
            if (words[3].equals("refused")) {
                String msgToSend = words[1] + "  Refused your request";
                userProfileController.textArea.appendText("\n"+msgToSend);
            }
        }
    }
}
