package com.savin.greengrocerapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button signinBtn,signupBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinBtn = (Button)findViewById(R.id.signinBtn);
        signupBtn = (Button)findViewById(R.id.signupBtn);


    signinBtn.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View view){
            Intent signin = new Intent(MainActivity.this,signin.class);
            startActivity(signin);
        }
    });

        signupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent SignUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(SignUp);
            }
        });



}
}
