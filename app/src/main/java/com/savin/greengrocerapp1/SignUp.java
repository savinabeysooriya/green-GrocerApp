package com.savin.greengrocerapp1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.savin.greengrocerapp1.Model.user;

public class SignUp extends AppCompatActivity {

    EditText editphone,editpassword,editName;
    Button SignUpbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editphone = (EditText)findViewById(R.id.editphone);
        editName = (EditText)findViewById(R.id.editName);
        editpassword=(EditText)findViewById(R.id.editpassword);
        SignUpbutton=(Button) findViewById(R.id.SignUPbutton);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user= database.getReference("user");

        SignUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mdialog = new ProgressDialog(SignUp.this);
                mdialog.setMessage("please waiting...");

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(editphone.getText().toString()).exists()){
                            mdialog.dismiss();
                            Toast.makeText(getApplicationContext(), "User is already exist", Toast.LENGTH_SHORT).show();
                        }else{
                            mdialog.dismiss();
                            user userobj=new user(editName.getText().toString(),editpassword.getText().toString());
                            table_user.child(editphone.getText().toString()).setValue(userobj);
                            Toast.makeText(getApplicationContext(), "Sign Up successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
