package com.areeb.patholab.BottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.areeb.patholab.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BookSlot extends BottomSheetDialogFragment {
    LinearLayout btnBookSlot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_slot_dialoguesheet,container,false);
        btnBookSlot= view.findViewById(R.id.btnSlot);

        btnBookSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "botton Click", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
