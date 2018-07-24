package com.example.chemlleijoseph.summer18project;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.chemlleijoseph.summer18project.fragments.accountFragment;
import com.example.chemlleijoseph.summer18project.fragments.homeFragment;
import com.example.chemlleijoseph.summer18project.fragments.moviesFragment;
import com.example.chemlleijoseph.summer18project.fragments.theatersFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements moviesFragment.OnFragmentInteractionListener, theatersFragment.OnFragmentInteractionListener, accountFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.item_movies:
                        selectedFragment = moviesFragment.newInstance();
                        break;
                    case R.id.item_theaters:
                        selectedFragment = theatersFragment.newInstance();
                        break;
                    case R.id.item_account:
                        selectedFragment = accountFragment.newInstance();
                        break;
                    default:
                        selectedFragment = homeFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.item_home); // change to whichever id should be default
        }

        Bundle bundle = getIntent().getExtras();

//        String one = bundle.getString("email");
//        String two = bundle.getString("password");

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
