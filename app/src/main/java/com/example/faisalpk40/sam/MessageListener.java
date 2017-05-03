package com.example.faisalpk40.sam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kevin.omd on 5/1/2017.
 *  - added existing server code. Will need to be changed, here as reference
 */

public class MessageListener extends AppCompatActivity {

    private ServerSocket servSock;
    Handler updateLogHandler;
    Thread serverThread = null;
    private TextView text;
    public static final int SERVERPORT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox);
        text = (TextView) findViewById(R.id.text2);
        updateLogHandler = new Handler();
        this.serverThread = new Thread(new ServerThread());
        this.serverThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        try{
            servSock.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    class ServerThread implements Runnable{
        public void run(){
            Socket socket = null;
            try{
                servSock = new ServerSocket(SERVERPORT);
            } catch (IOException e){
                e.printStackTrace();
            }
            while(!Thread.currentThread().isInterrupted()){
                try{
                    socket = servSock.accept();
                    CommunicationThread commThread = new CommunicationThread(socket);
                    new Thread(commThread).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class CommunicationThread implements Runnable{
        private Socket clientSock;
        private BufferedReader input;
        public CommunicationThread(Socket clientSock){
            this.clientSock = clientSock;
            try{
                this.input = new BufferedReader(new InputStreamReader(this.clientSock.getInputStream()));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                try{
                    String read = input.readLine();
                    updateLogHandler.post(new updateUIThread(read));
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class updateUIThread implements Runnable{
        private String buf;
        public updateUIThread(String str){
            this.buf=str;
        }
        @Override
        public void run(){
            text.setText(text.getText().toString()+"User Says: "+buf+"\n");
        }
    }
}

