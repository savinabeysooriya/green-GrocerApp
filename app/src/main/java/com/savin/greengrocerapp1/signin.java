package com.savin.greengrocerapp1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.savin.greengrocerapp1.Model.user;

import java.io.Console;

public class signin extends AppCompatActivity {

    EditText editphone,editpassword;
    Button Signbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editphone = (EditText)findViewById(R.id.editphone);
        editpassword=(EditText)findViewById(R.id.editpassword);
        Signbutton=(Button) findViewById(R.id.Signbutton);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user= database.getReference("user");

        Signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mdialog = new ProgressDialog(signin.this);
                mdialog.setMessage("please waiting...");

                if (!TextUtils.isEmpty(editphone.getText().toString().trim()) && !TextUtils.isEmpty(editpassword.getText().toString().trim())) {
                    table_user.addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child(editphone.getText().toString()).exists()) {
                                mdialog.dismiss();
                                user userobj = dataSnapshot.child(editphone.getText().toString()).getValue(user.class);

                                if (userobj.getPassword().equals(editpassword.getText().toString())) {
                                    Toast.makeText(getApplicationContext(), "sign in successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Sign in failed", Toast.LENGTH_SHORT).show();
                                }
                            } else {

                                mdialog.dismiss();

                                Toast.makeText(getApplicationContext(), "user is not exist", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

    }
}
