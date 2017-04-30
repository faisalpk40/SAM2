package com.example.faisalpk40.sam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by faisalpk40 on 4/29/2017.
 */

public class SignUp extends Activity {


    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.BsignupButton) {
            EditText name = (EditText) findViewById(R.id.TFname);
            EditText email = (EditText) findViewById(R.id.TFemail);
            EditText uname = (EditText) findViewById(R.id.TFuname);
            EditText pass1 = (EditText) findViewById(R.id.TFpass1);
            EditText pass2 = (EditText) findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();


            if (!pass1str.equals(pass2str)) {
                //pop up message
                Toast pass = Toast.makeText(SignUp.this, "Password Don't match!", Toast.LENGTH_SHORT);
                pass.show();


            } else {
                Toast signup = Toast.makeText(SignUp.this, "Sign-up successful!", Toast.LENGTH_SHORT);
                signup.show();
                // Inserts the details in DataBase
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);

                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);

            }

        }

    }
}


