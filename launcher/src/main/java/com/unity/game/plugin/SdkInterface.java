package com.unity.game.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import java.util.Map;

/**
 * @author snote
 * @date 2025/5/16 16:42
 * @description 生命周期接口
 */
public interface SdkInterface {

    void onCreate(Activity activity);

    void onStart(Activity activity);

    void onResume(Activity activity);

    void onRestart(Activity activity);

    void onPause(Activity activity);

    void onStop(Activity activity);

    void onDestroy(Activity activity);

    void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data);

    void onNewIntent(Intent intent);

    void onSaveInstanceState(Bundle outState);

    void onRestoreInstanceState(Bundle bundle);

    void onWindowFocusChanged(boolean hasFocus);

    void onBackPressed();

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

    boolean dispatchKeyEvent(KeyEvent event);

    boolean dispatchTouchEvent(MotionEvent ev);

    void onConfigurationChanged(Activity activity, Configuration newConfig, Resources res);

    Resources getResources(Resources res);

}
