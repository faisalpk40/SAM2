package com.example.faisalpk40.sam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu; this adds items to the action bar if it is present
         getMenuInflater().inflate(R.menu.menu_main, menu);
         return true;
     }*/
    public void onButtonClick(View v)
    {

        if(v.getId() == R.id.Blogin)
        {
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)) //&& !pass.equals(""))
            {
                Toast temp = Toast.makeText(MainActivity.this, "Log-in successful!", Toast.LENGTH_SHORT);
                temp.show();
                Intent i = new Intent(MainActivity.this, Main.class);
                i.putExtra("Username", str);
                startActivity (i);
            }
            else {
                //pop up message
                Toast temp = Toast.makeText(MainActivity.this, "Username and Password Don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }



        }
        if(v.getId()== R.id.Bsignup)
        {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity (i);
        }
    }
}
