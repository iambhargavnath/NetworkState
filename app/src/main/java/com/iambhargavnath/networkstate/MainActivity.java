package com.iambhargavnath.networkstate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NetworkChangeReceiver.ConnectionChangeCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to call the Network Broadcast Receiver
        IntentFilter intentFilter = new
                IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
        networkChangeReceiver.setConnectionChangeCallback(this);

    }

    @Override
    public void onConnectionChange(boolean isConnected) {
        if(isConnected){
            // this block will run when connected
            Toast.makeText(this, "Network Connected", Toast.LENGTH_SHORT).show();
        }
        else{
            // this block will run when disconnected
            Toast.makeText(this, "Network Disconnected", Toast.LENGTH_SHORT).show();
        }

    }

}