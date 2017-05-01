package com.example.faisalpk40.sam;

import android.os.Bundle;

/**
 * Created by kevin.omd on 5/1/2017.
 */

public class Message {
    //Member Variables
    String sendr; // username of sender
    String recvr; // username of recipient
    String msgData; // message text

    boolean delivered; // tracks if message has left client buffer for delivery time out
    boolean read; // tracks if message has been read by recipient for time deletion

    // needs two values to store time-stamps:
    // - one that records when message is queued for delivery (24 hours undelivered then deleted sender side)
    // - one that records when message is opened by recipient (1 minute after opening then deleted recipient side)

    // needs a way to track the number and type of encryption on the message

    //Constructor
    public Message(String sendr, String recvr, String msgData){
        this.sendr = sendr;
        this.recvr = recvr;
        this.msgData = msgData;

        this.delivered = false;
        this.read = false;
    }

    //Setters and Getters
    public boolean isDelivered(){
        return delivered;
    }

    public boolean isRead(){
        return read;
    }

    public void markDelivered(){
        delivered = true;
    }

    public void markRead(){
        read = true;
    }

    public String getMsgData(){
        return msgData;
    }

    public String getSendr(){
        return sendr;
    }

    public String getRecvr() {
        return recvr;
    }

    public void setMsgData(String data){
        this.msgData = data;
    }

    public void setSendr(String data){
        this.sendr = data;
    }

    public void setRecvr(String data){
        this.recvr = data;
    }

    //Packages data into bundle for sending between devices
    public Bundle toBundle(){
        Bundle b = new Bundle();

        b.putString("send", sendr);
        b.putString("recv", recvr);
        b.putString("data", msgData);
        b.putBoolean("deli", delivered);
        b.putBoolean("read", read);

        return b;
    }
}
