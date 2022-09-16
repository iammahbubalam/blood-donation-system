package com.mahbubalam.blooddonationsystem.socketserver;

import com.mahbubalam.blooddonationsystem.util.Data;
import com.mahbubalam.blooddonationsystem.util.Information;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;

import java.util.HashMap;

public class ReaderWriterServer implements Runnable {
    int id;
    NetworkUtility networkUtility;
    HashMap<Integer, Information> clientList;

    public ReaderWriterServer(int id, NetworkUtility networkUtility, HashMap<Integer, Information> clientList) {
        this.id = id;
        this.networkUtility = networkUtility;
        this.clientList = clientList;
    }

    //    words[0] = Sender Id
//    words[1] = Receiver Id
//    words[2] = Sender Name
//    words[3] = keyword
//    words[4] = message/null
    @Override
    public void run() {

        while (true) {
            Object obj = networkUtility.read();
            Data dataObj = (Data) obj;
            String actualMessage = dataObj.message;
            System.out.println(actualMessage);
            String[] words = actualMessage.split("\\$");
            if (words[3].equals("text")) {
                Information info = clientList.get(Integer.parseInt(words[1]));
                String msgToSend = words[0] + "$" + words[2] + "$" + "text" + "$" + words[4];
                System.out.println("sending.." + msgToSend);
                info.networkUtility.write(msgToSend);
            }
            if (words[3].equals("requestForBlood")) {
                Information info = clientList.get(Integer.parseInt(words[1]));
                String msgToSend = words[0] + "$" + words[2] + "$" + "requestForBlood" + "$" + words[4];
                info.networkUtility.write(msgToSend);

            }
            if (words[3].equals("donateBlood")) {
                Information info = clientList.get(Integer.parseInt(words[1]));
                String msgToSend = words[0] + "$" + words[2] + "$" + "donateBlood" + "$" + "Want to Donate you blood" + "$" + words[4];
                info.networkUtility.write(msgToSend);

            }
            if (words[3].equals("accepted")) {
                Information info = clientList.get(Integer.parseInt(words[1]));
                String msgToSend = words[0] + "$" + words[2] + "$" + "accepted" + "$" + "Accepted your request" + "$" + words[4];
                info.networkUtility.write(msgToSend);
            }
            if (words[3].equals("refused")) {
                Information info = clientList.get(Integer.parseInt(words[1]));
                String msgToSend = words[0] + "$" + words[2] + "$" + "refused" + "$" + "Refused your request" + "$" + words[4];
                info.networkUtility.write(msgToSend);
            }
        }
    }
}
