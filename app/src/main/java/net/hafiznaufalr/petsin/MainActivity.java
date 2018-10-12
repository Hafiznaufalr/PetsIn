package net.hafiznaufalr.petsin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import net.hafiznaufalr.petsin.cart.Cart;
import net.hafiznaufalr.petsin.fragments.AkunFragment;
import net.hafiznaufalr.petsin.fragments.FeedFragment;
import net.hafiznaufalr.petsin.fragments.HomeFragment;
import net.hafiznaufalr.petsin.fragments.InboxFragment;
import net.hafiznaufalr.petsin.fragments.NotifFragment;
import net.hafiznaufalr.petsin.logout.Logout;
import net.hafiznaufalr.petsin.scanner.Scanner;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_feed:
                fragment = new FeedFragment();
                break;

            case R.id.navigation_chat:
                fragment = new InboxFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotifFragment();
                break;
            case R.id.navigation_akun:
                fragment = new AkunFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_cart:
                Intent cIntent = new Intent(this, Cart.class);
                startActivity(cIntent);
                break;

            case R.id.action_scan:
                Intent sIntent = new Intent(this, Scanner.class);
                startActivity(sIntent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
