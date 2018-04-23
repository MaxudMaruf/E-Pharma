package com.arka.dubusportal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class window1 extends AppCompatActivity {

    Button signup;
    EditText mail,pass;
    String Email,Pass;
    final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window1);
        signup=findViewById(R.id.signup);
        mail=findViewById(R.id.email);
        //Email=mail.getText().toString();
        pass = findViewById(R.id.password);
        //Pass=pass.getText().toString();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(mail.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(window1.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(window1.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });
                startNextActivity();

            }
        });


    }
    private void startNextActivity() {
        if(mail.getText().toString().length()<=5|| pass.getText().toString().length()<=5)
        {
            Toast.makeText(this,"Invalid Email or Password",Toast.LENGTH_LONG);
        }
        else {

            Intent p = new Intent(window1.this, Home.class);
            startActivity(p);
        }
    }

}
