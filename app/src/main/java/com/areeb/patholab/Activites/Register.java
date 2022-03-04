package com.areeb.patholab.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.areeb.patholab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    EditText rg_fullName, rg_phone, rg_email, rg_password, rg_conPass;
    Button register_btn;
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        rg_fullName = findViewById(R.id.reg_fullname);
        rg_phone = findViewById(R.id.reg_phone_number);
        rg_email = findViewById(R.id.reg_email);
        rg_password = findViewById(R.id.reg_pass);
        rg_conPass = findViewById(R.id.reg_conf_pass);
        register_btn = findViewById(R.id.register_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register_fun();
            }

        });


    }

    private void register_fun() {

        String email, password, confirm_pass, phone, fullname;
        email = rg_email.getText().toString();
        password = rg_password.getText().toString();
        confirm_pass = rg_conPass.getText().toString();
        phone = rg_phone.getText().toString();
        fullname = rg_fullName.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "please fill email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "please fill password", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(confirm_pass)) {
            Toast.makeText(getApplicationContext(), "please fill confirm_password", Toast.LENGTH_SHORT).show();
        }


        //creating new user logic

        try{


            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Welcome to the family", Toast.LENGTH_SHORT).show();

                        FirebaseUser appuser = mAuth.getCurrentUser();
                        DocumentReference df = fstore.collection("Users").document(appuser.getUid());
                        HashMap<String, Object> userinfo = new HashMap<>();
                        userinfo.put("Fullname", rg_fullName.getText().toString());
                        userinfo.put("UserEmail", rg_email.getText().toString());
                        userinfo.put("Phone", rg_phone.getText().toString());
                        userinfo.put("isAdmin", "0");


                        df.set(userinfo);

                        Intent intent = new Intent(new Intent(Register.this, Login.class));
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "some error happen in backend", Toast.LENGTH_SHORT).show();


                    }

                }
            });

        }catch (Exception e){
            Log.e("bhai",e.toString());
        }


    }
}