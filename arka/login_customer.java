package com.arka.dubusportal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class login_customer extends AppCompatActivity {

    Button b;
    EditText email,password,emailfield,passwordfield;
    String emai,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window2);
        b=(Button)findViewById(R.id.loginbutt);
        email=findViewById(R.id.emailcus);
        password=findViewById(R.id.password);
        emailfield=findViewById(R.id.emailcus);
         pass = emailfield.getText().toString();
        passwordfield=findViewById(R.id.password);
         emai = passwordfield.getText().toString();
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null)
        {
            startNextActivity();
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(login_customer.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user.
//Log.w(TAG, "signInWithEmail:failure", task.getException());
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //
                                    // updateUI(user);
                                    startNextActivity();
                                } else {
                                    Toast.makeText(login_customer.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
                startNextActivity();


;

            }
        });
    }

    private void startNextActivity() {
        if(emai.length()<5 || pass.length()<5)
        {

            Toast.makeText(this,"Email or Password is not valid",Toast.LENGTH_LONG);
        }
        else {
            Intent p = new Intent(login_customer.this, Mainwindow.class);
            startActivity(p);
        }
    }
}
