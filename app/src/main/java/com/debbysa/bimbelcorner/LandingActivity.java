package com.debbysa.bimbelcorner;

import android.Manifest;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.debbysa.bimbelcorner.fragments.AddFragment;
import com.debbysa.bimbelcorner.fragments.BimbelFragment;
import com.debbysa.bimbelcorner.fragments.LoginFragment;
import com.debbysa.bimbelcorner.models.User;

public class LandingActivity extends AppCompatActivity implements LoginFragment.OnLoginFragmentListener,
        BimbelFragment.OnBimbelFragmentListener{

    Settings settings;
    Session session;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    //database
    Database mydb;

    //component di xml
    EditText textNama, textAlamat, textDeskripsi;
    ImageView image;
    Button buttonAdd, buttonPilih;

    public static Database database;

    final int REQUEST_CODE_GALLERY = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        settings = new Settings(this);
        session = new Session(settings);

        addFragment();

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragment here
        viewPagerAdapter.addFragment(new BimbelFragment(),"");
        viewPagerAdapter.addFragment(new AddFragment(),"");
//        viewPagerAdapter.addFragment( ,"LOGOUT");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_create);

        //remove shadow from action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        //database
        mydb = new Database(this);

        init();

//        buttonPilih.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ActivityCompat.requestPermissions(
//                        LandingActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        REQUEST_CODE_GALLERY
//                );
//            }
//        });


//        addData();

    }

    private void init(){
        textNama = findViewById(R.id.text_nama);
        textAlamat = findViewById(R.id.text_alamat);
        textDeskripsi = findViewById(R.id.text_deskripsi);
        image = findViewById(R.id.gambar);
        buttonPilih = findViewById(R.id.button_pilih);
        buttonAdd = findViewById(R.id.button_add);
    }

    public void addData(){

//        buttonAdd.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isInserted = mydb.insertData(textNama.getText().toString(),
//                                textAlamat.getText().toString(),
//                                textDeskripsi.getText().toString());
//                        if(isInserted == true)
//                            Toast.makeText(LandingActivity.this,"Data Tersimpan",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(LandingActivity.this,"Data Gagal Tersimpan",Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//
//        switch (item.getItemId()) {
//            case R.id.action_logout:
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void addFragment(){
        Fragment fragment = null;
        if (session.isLogin()) {
            fragment = new BimbelFragment();
            ((BimbelFragment) fragment).setListener(this);
        } else {
            fragment = new LoginFragment();
            ((LoginFragment) fragment).setListener(this);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }


//    private void createSettingFragment() {
//        Fragment settingsFragment = new SettingsFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, settingsFragment)
//                .addToBackStack(null)
//                .commit();
//    }

    @Override
    public void onLoginClicked(View view, String username, String password) {
        User user = session.doLogin(username, password);
        String message = "Authentication failed";
        if (user != null) {
            message = "Welcome " + username;
            session.setUser(username);
            addFragment();
        }
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    // implement method di bimbel fragment
    @Override
    public void onLogoutClick() {
        session.doLogout();
        addFragment();
    }


}
