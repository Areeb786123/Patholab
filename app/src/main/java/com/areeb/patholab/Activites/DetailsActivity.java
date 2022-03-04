package com.areeb.patholab.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.areeb.patholab.BottomSheet.BookSlot;
import com.areeb.patholab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailsActivity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    FirebaseFirestore fstore;
    FirebaseDatabase firebaseDatabase;
    TextView labName, labPhone,labemail,testid;

    LinearLayout make_appointment_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        labName= findViewById(R.id.Labname);
        labPhone= findViewById(R.id.Phone);
        labemail= findViewById(R.id.labemail);
        testid= findViewById(R.id.testId);
        make_appointment_btn= findViewById(R.id.makeAppointment);

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        fstore=FirebaseFirestore.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        labName.setText(getIntent().getStringExtra("Fullname"));
        labemail.setText(getIntent().getStringExtra("AdminEmail"));
        labPhone.setText(getIntent().getStringExtra("Phone"));
        testid.setText(getIntent().getStringExtra("AdminId"));


        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        make_appointment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BookSlot bookSlotSheet = new BookSlot();
                Bundle bundle = new Bundle();
                bundle.putString("Fullname", labName.getText().toString());
                bundle.putString("AdminEmail", labemail.getText().toString());
                bundle.putString("Phone", labPhone.getText().toString());
                bundle.putString("AdminId",testid.getText().toString());
                bookSlotSheet.setArguments(bundle);

                bookSlotSheet.show(getSupportFragmentManager(),"bookSlot");

            }
        });

    }

    private void makeAppointment() {

        if (firebaseUser!= null) {
            Intent makeappointment = new Intent(DetailsActivity.this,BookSlot.class);
            makeappointment.putExtra("Fullname", labName.getText().toString());
            makeappointment.putExtra("AdminEmail", labemail.getText().toString());
            makeappointment.putExtra("Phone", labPhone.getText().toString());
            makeappointment.putExtra("AdminId",testid.getText().toString());
            startActivity(makeappointment);
        }else{
            Toast.makeText(getApplicationContext(), "Please Login", Toast.LENGTH_SHORT).show();
        }

    }
}