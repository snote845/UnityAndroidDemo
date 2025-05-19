package com.unity.game;

import android.os.Bundle;

import com.unity.game.plugin.SdkManager;
import com.unity3d.player.IUnityPlayerLifecycleEvents;
import com.unity3d.player.UnityPlayerActivity;

/**
 * @author snote
 * @date 2025/5/16 10:51
 * @description GameMainActivity
 */
public class GameActivity extends UnityPlayerActivity implements IUnityPlayerLifecycleEvents {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize your game here
        SdkManager.getInstance().init(this);
        SdkManager.getInstance().onCreate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SdkManager.getInstance().onStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SdkManager.getInstance().onResume(this);
    }

    @Override
    public void onUnityPlayerUnloaded() {
        // Handle Unity player unloaded event
    }

    @Override
    public void onUnityPlayerQuitted() {
        // Handle Unity player quitted event
    }


}
