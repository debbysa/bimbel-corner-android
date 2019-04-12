package com.debbysa.bimbelcorner.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.debbysa.bimbelcorner.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    //component di xml
    EditText textNama, textAlamat, textDeskripsi;
    Button buttonAdd;
    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

}
