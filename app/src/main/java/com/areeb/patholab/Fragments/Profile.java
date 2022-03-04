package com.areeb.patholab.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import com.areeb.patholab.Activites.Login;
import com.areeb.patholab.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 *
 *
 */
public class Profile extends Fragment {


CardView card1,card2 ,card3;
TextView  name ,email,phone;
//LazyLoader nprogressBar;
 FirebaseAuth firebaseAuth;
 FirebaseUser firebaseUser;
 FirebaseFirestore fstore;
CardView logout_btn;
ImageView profile_image;
 FirebaseDatabase firebaseDatabase;


    public Profile() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        card1 = view.findViewById(R.id.card1);


        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        logout_btn = view.findViewById(R.id.logout_btn);

        profile_image= view.findViewById(R.id.userImage);

//        nprogressBar= view.findViewById(R.id.nprogress);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser= firebaseAuth.getCurrentUser();
        fstore = FirebaseFirestore.getInstance();
//
//        Glide.with(getContext()).load("http://goo.gl/gEgYUd").into(profile_image);

        FirebaseUser currentUser =  firebaseAuth.getCurrentUser();
        DocumentReference df =  fstore.collection("Users").document(currentUser.getUid());
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

//               nprogressBar.setVisibility(View.GONE);
               card1.setVisibility(View.VISIBLE);
//               card2.setVisibility(View.VISIBLE);
//               card3.setVisibility(View.VISIBLE);

               if(documentSnapshot.exists()){
                   String user_name = documentSnapshot.getString("Fullname");
                   String user_email = documentSnapshot.getString("Phone");
                   String user_phone = documentSnapshot.getString("UserEmail");

                   name.setText( user_name);
                   email.setText(user_email);
                   phone.setText(user_phone);


               }

            }
        });



        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();

                Intent logout = new Intent(getActivity(),Login.class);
                startActivity(logout);


            }
        });


        return view;
    }
}