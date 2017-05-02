package com.example.faisalpk40.sam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by faisalpk40 on 4/30/2017.
 * Edited by kevin.omd on 5/1/2017.
 *  - added existing client code
 */

public class Send extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    private Socket sock;
    private EditText edt;
    private String str;
    OutputStreamWriter oStream;
    PrintWriter msgOut;
    //Button bSend;

    //KM: these will change to the address of of the selected recipient
    private static final int SERVERPORT = 5000;
    private static final String SERVERIP = "127.0.0.1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        try{
            //InetAddress servAddr = InetAddress.getByName(SERVERIP);
            sock = new Socket(SERVERIP, SERVERPORT);
            Toast.makeText(Send.this, "Socket Created!", Toast.LENGTH_LONG).show();
            oStream = new OutputStreamWriter(sock.getOutputStream());
            msgOut = new PrintWriter(oStream);
        } catch (UnknownHostException e1){
            Toast.makeText(Send.this, "Socket Error!", Toast.LENGTH_LONG).show();
            e1.printStackTrace();
        } catch (IOException e1){
            Toast.makeText(Send.this, "IO Error!", Toast.LENGTH_LONG).show();
            e1.printStackTrace();
        } catch (Exception e1){
            Toast.makeText(Send.this, "Exceptional Error!", Toast.LENGTH_LONG).show();
            e1.printStackTrace();
        }
        //new Thread(new ClientThread()).start();
        //bSend = (Button) findViewById(R.id.sendButton);
    }

    public void onButtonClick(View view){
        try {
            edt = (EditText) findViewById(R.id.clientText);
            str = edt.getText().toString();
            //Pretty sure the problem is somewhere here

            msgOut.print(str + "\n");
            Toast.makeText(Send.this, "Message Sent!", Toast.LENGTH_LONG).show();
            msgOut.flush();
        } catch (Exception e){
            Toast.makeText(Send.this, "Exceptional Error!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /*class ClientThread implements Runnable{
        @Override
        public void run(){

        }
    }*/
}