package com.debbysa.bimbelcorner.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.debbysa.bimbelcorner.Bimbel;
import com.debbysa.bimbelcorner.BimbelAdapter;
import com.debbysa.bimbelcorner.LandingActivity;
import com.debbysa.bimbelcorner.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BimbelFragment extends Fragment {

    private ArrayList<Bimbel> dataList;
    private OnBimbelFragmentListener listener;


    public BimbelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        addData();
        View view = inflater.inflate(R.layout.fragment_bimbel, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        BimbelAdapter bimbelAdapter = new BimbelAdapter(dataList);
        recyclerView.setAdapter(bimbelAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }

    void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Bimbel("Primagama", "Malang", "adalah suatu..."));
        dataList.add(new Bimbel("Master Prima", "Kepanjen", "adalah suatu..."));
    }

    public void setListener(LandingActivity landingActivity) {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_logout:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public interface OnBimbelFragmentListener {
        void onLogoutClick();
    }
}
