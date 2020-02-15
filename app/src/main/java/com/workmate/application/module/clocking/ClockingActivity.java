package com.workmate.application.module.clocking;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
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
import com.workmate.application.model.request.ClockRequest;
import com.workmate.application.model.response.ClockResponse;
import com.workmate.application.module.clocking.pattern.ClockingDoPresenter;
import com.workmate.application.module.clocking.pattern.ClockingPresenter;
import com.workmate.application.module.clocking.pattern.ClockingView;
import com.workmate.application.module.main.MainActivity;
import com.workmate.application.module.main.pattern.MainPresenter;
import com.workmate.application.utils.NetworkUtils;
import com.workmate.application.utils.Session;

import butterknife.BindView;

public class ClockingActivity extends BaseActivity implements ClockingView, View.OnClickListener {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.tv_cancel)
    TextView tv_cancel;
    CountDownTimer mCountDownTimer;
    int i = 0;

    private ClockingPresenter clockingPresenter;
    private Session session;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        getSupportActionBar().hide();

        clockingPresenter = new ClockingDoPresenter(this, this);
        session = new Session(this);
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
//                LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                if (ContextCompat.checkSelfPermission(ClockingActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                        ContextCompat.checkSelfPermission(ClockingActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    Activity#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for Activity#requestPermissions for more details.
//                    return;
//                }
//                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                double longitude = location.getLongitude();
//                double latitude = location.getLatitude();
//
//                Log.i("LOCATION", latitude+" dan long "+longitude);

                i++;
                progressBar.setProgress(100);
                clockIn();
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

    @Override
    public void clockIn() {
        if (NetworkUtils.isNetAvailable(this)) {
            ClockRequest clockRequest = new ClockRequest();
            clockRequest.setLatitute("-6.2446691");
            clockRequest.setLongitude("106.8779625");
            clockRequest.setToken("token "+session.getKey());
            clockingPresenter.sendClockIn(clockRequest);
        }
    }

    @Override
    public void getClockIn(ClockResponse response) {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
