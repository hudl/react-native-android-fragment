package com.hudl.oss.react.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.hudl.oss.react.fragment.ReactFragment;

public class MainActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {

    private static final String COMPONENT_NAME = "SampleApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ReactFragment reactFragment = new ReactFragment.Builder(COMPONENT_NAME).build();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_main, reactFragment)
                    .commit();
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
}
