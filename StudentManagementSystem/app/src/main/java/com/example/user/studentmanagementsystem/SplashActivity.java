package com.example.user.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * this is splash screen
 */
public class SplashActivity extends AppCompatActivity {


    /**
     * going to call student list activity
     *
     * @param savedInstanceState
     */

    public static final int DELAY = 1000;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getBaseContext(), AddStudentActivity.class);
                startActivity(intent);
            }
        });
        t.start();
    }
}
