package net.hafiznaufalr.petsin.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.login.Login;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(1000); //
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    startActivity(new Intent(Splash.this, Login.class));
                    finish(); // Menutup Activity
                }
            }
        };
        thread.start();
    }
}