package com.example.faisalpk40.sam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by faisalpk40 on 4/30/2017.
 */

public class Main extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }


    public void onButtonClick(View v) {
        if(v.getId() == R.id.sendScreenButton){
            Intent i = new Intent(Main.this, Send.class);
            startActivity (i);
        }

    }

}