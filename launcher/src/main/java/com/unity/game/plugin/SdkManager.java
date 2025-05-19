package com.unity.game.plugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.fastjson.JSONObject;
import com.unity3d.player.UnityPlayer;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author snote
 * @date 2025/5/16 14:06
 * @description unity 与Android 交互接口
 */
public class SdkManager extends SdkPluginManager {

    private static final String TAG = "UnitySdkManager---";
    @SuppressLint("StaticFieldLeak")
    private static SdkManager instance;

    private Activity mActivity;

    private SdkManager() {
    }

    public static synchronized SdkManager getInstance() {
        if (instance == null) {
            instance = new SdkManager();
        }
        return instance;
    }

    public void init(Activity mActivity) {
        this.mActivity = mActivity;
        Log.i(TAG, "init");

    }

    public void login() {
        toastUtils("login");

        toastUtils("Android 调用 login 完成，通知 Unity 登录成功");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        jsonObject.put("msg", "msg");
        jsonObject.put("token", "outToken");

        String str = jsonObject.toJSONString();

        Log.i(TAG, "login: " + str);

        // 模拟登录成功，延迟4秒后通知 Unity 登录成功
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                UnityPlayer.UnitySendMessage("AndroidMsgReceiver", "OnLoginResult", str);
            }
        };
        new Timer().schedule(timerTask, 4000);
    }

    public void logout() {
        toastUtils("logout");

        UnityPlayer.UnitySendMessage("AndroidMsgReceiver", "OnLogout", "logoutSuccess");
    }

    public void pay() {
        toastUtils("pay");
    }

    public void enterServer(String json) {
        Log.i(TAG, "enterServer: " + json);
    }
    public void exit() {
        toastUtils("exit");
    }

    private void toastUtils(String msg) {
        Log.i(TAG, "msg");
        mActivity.runOnUiThread(() -> {
            Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
        });
    }

    public Activity getActivity() {
        return mActivity;
    }
}
