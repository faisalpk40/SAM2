package com.example.faisalpk40.sam;

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

    // needs two time values, one that records when message is queued for delivery and one
    // that records when message is opened by recipient

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

    public void setMsgData(String data){
        this.msgData = data;
    }

    public void setSendr(String data){
        this.sendr = data;
    }

    public void setRecvr(String data){
        this.recvr = data;
    }
}
