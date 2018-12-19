package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.hudl.oss.react.fragment.ReactFragment;

public class MainActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {

    private static final String COMPONENT_NAME = "example";

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

    /**
     * Forward onKeyUp events to the ReactFragment in order to handle double tap reloads
     * and dev menus
     *
     * @param keyCode
     * @param event
     * @return true if event was handled
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean handled = false;
        Fragment activeFragment = getSupportFragmentManager().findFragmentById(R.id.container_main);
        if (activeFragment instanceof ReactFragment) {
            handled = ((ReactFragment) activeFragment).onKeyUp(keyCode, event);
        }
        return handled || super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Fragment activeFragment = getSupportFragmentManager().findFragmentById(R.id.container_main);
        if (activeFragment instanceof ReactFragment) {
            ((ReactFragment) activeFragment).onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment activeFragment = getSupportFragmentManager().findFragmentById(R.id.container_main);
        if (activeFragment instanceof ReactFragment) {
            ((ReactFragment) activeFragment).onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Fragment activeFragment = getSupportFragmentManager().findFragmentById(R.id.container_main);
        if (activeFragment instanceof ReactFragment) {
            ((ReactFragment) activeFragment).onNewIntent(intent);
        }
    }
}
