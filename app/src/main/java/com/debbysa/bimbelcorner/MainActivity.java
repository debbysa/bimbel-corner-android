package com.debbysa.bimbelcorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

//        addFragment();
    }

//    private void addFragment() {
//        Fragment fragment = (session.isLogin()) ? new BimbelFragment() : new LoginFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit();
//        changeFragment(fragment, false);
//    }

//    private void changeFragment(Fragment fragment, boolean addToBackStack) {
//        FragmentTransaction transaction = getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container, fragment);
//        if (addToBackStack) {
//            transaction.addToBackStack(null);
//        }
//        transaction.commit();
//    }

    public void LaunchSearch(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void LaunchLogin(View view){
        Intent intent = new Intent(this, LandingActivity.class);
        startActivity(intent);
    }


}
