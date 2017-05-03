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

    //KM: these will change to the address of of the selected recipient
    private static final int SERVERPORT = 5000;
    //private static final String SERVERIP = "172.24.2.42";
    private static final String SERVERIP = "10.0.2.2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        new Thread(new ClientThread()).start();
    }

    public void onButtonClick(View view){
        try{
            EditText edt = (EditText) findViewById(R.id.clientText);
            String str = edt.getText().toString();
            //Pretty sure the problem is somewhere here
            OutputStreamWriter msgOut = new OutputStreamWriter(sock.getOutputStream());
            msgOut.write(str + "\n");
            Toast.makeText(Send.this, "Message Sent!", Toast.LENGTH_LONG).show();
            msgOut.flush();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*protected void onStop() {
        super.onStop();
        try{
            sock.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }*/

    class ClientThread implements Runnable{
        @Override
        public void run(){
            try{
                //InetAddress servAddr = InetAddress.getByName(SERVERIP);
                sock = new Socket(SERVERIP, SERVERPORT);
                if(sock.isConnected()){
                    //Toast.makeText(Send.this, "Socket Created!", Toast.LENGTH_LONG).show();
                }
                else{
                    //Toast.makeText(Send.this, "Socket Creation FAILED!", Toast.LENGTH_LONG).show();
                }
            } catch (UnknownHostException e1){
                e1.printStackTrace();
            } catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }
}