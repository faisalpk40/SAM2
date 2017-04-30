package com.example.faisalpk40.sam;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by faisalpk40 on 4/30/2017.
 */

public class Send extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
    }
}
