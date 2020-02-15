package com.workmate.application.module.clocking;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.workmate.application.R;
import com.workmate.application.base.BaseActivity;
import com.workmate.application.module.main.MainActivity;

import butterknife.BindView;

public class ClockingActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.tv_cancel)
    TextView tv_cancel;
    CountDownTimer mCountDownTimer;
    int i = 0;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        getSupportActionBar().hide();
        tv_cancel.setOnClickListener(this);
        progressBar.getProgressDrawable().setColorFilter(
                Color.parseColor("#FFFFFF"), android.graphics.PorterDuff.Mode.SRC_IN);
        progressBar.setProgress(i);
        FusedLocationProviderClient mFusedLocation = LocationServices.getFusedLocationProviderClient(this);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                i++;
                progressBar.setProgress((int) i * 100 / (10000 / 1000));
            }

            @Override
            public void onFinish() {

                i++;
                progressBar.setProgress(100);
            }
        };
        mCountDownTimer.start();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_clocking;
    }

    @Override
    public void onShowAlertDialog(String title, String message) {

    }

    @Override
    public void onShowToast(String message) {

    }

    @Override
    public void onHideDialog() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
                break;
        }
    }
}
