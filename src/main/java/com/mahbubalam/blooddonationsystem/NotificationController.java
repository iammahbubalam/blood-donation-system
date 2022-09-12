package com.mahbubalam.blooddonationsystem;

import com.mahbubalam.blooddonationsystem.socketclint.Reader;
import com.mahbubalam.blooddonationsystem.socketclint.Writer;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class NotificationController implements Initializable,Runnable {
    public int clintId;
    public Thread readerThread;
    public Thread writerThread;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(this).start();
    }

    @Override
    public void run() {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("www.google.com", 80));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client Started--- ");
        System.out.println(socket.getLocalAddress().getHostAddress());
        NetworkUtility networkUtility ;
        try {
            networkUtility = new NetworkUtility(socket.getLocalAddress().getHostAddress(), 9999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        networkUtility.write(2);

        readerThread = new Thread(new Reader(networkUtility,this));
        writerThread = new Thread(new Writer(networkUtility,this));

        readerThread.start();
        writerThread.start();

        try {
            readerThread.join();
            writerThread.join();
        } catch (Exception e) {
            System.out.println("Thread exited");
        }
    }
}
