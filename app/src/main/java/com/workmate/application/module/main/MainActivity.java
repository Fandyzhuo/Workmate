package com.workmate.application.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.workmate.application.R;
import com.workmate.application.base.BaseActivity;
import com.workmate.application.model.Staff;
import com.workmate.application.module.clocking.ClockingActivity;
import com.workmate.application.module.main.pattern.MainDoPresenter;
import com.workmate.application.module.main.pattern.MainPresenter;
import com.workmate.application.module.main.pattern.MainView;
import com.workmate.application.utils.NetworkUtils;
import com.workmate.application.utils.Session;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {

    @BindView(R.id.position_name) TextView position_name;
    @BindView(R.id.client_name) TextView client_name;
    @BindView(R.id.wage_amount) TextView wage_amount;
    @BindView(R.id.wage_type) TextView wage_type;
    @BindView(R.id.address_street1) TextView address_street1;
    @BindView(R.id.manager_name) TextView manager_name;
    @BindView(R.id.manager_phone) TextView manager_phone;
    @BindView(R.id.btn_clock_in_out) Button btn_clock;
    @BindView(R.id.btn_background) ImageView btn_background;
    @BindView(R.id.clock_in) TextView clock_in;
    @BindView(R.id.clock_out) TextView clock_out;

    private MainPresenter mainPresenter;
    private Session session;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        getSupportActionBar().hide();
        mainPresenter = new MainDoPresenter(this, this);
        session = new Session(this);
        btn_clock.setOnClickListener(this);
        sendStaffRequest();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_clock_in_out:
                startActivity(new Intent(this, ClockingActivity.class));
                break;
        }
    }

    @Override
    public void sendStaffRequest() {
        if (NetworkUtils.isNetAvailable(this)) {
            mainPresenter.sendStaff();
        }
    }

    @Override
    public void getStaff(Staff staff) {
        if (staff != null) {
            NumberFormat formatter = new DecimalFormat("#,###");
            String formattedNumber = formatter.format(staff.getWage_amount());

            List<String> items = Arrays.asList(staff.getWage_type().split("_"));
            client_name.setText(staff.getClient().getName());
            position_name.setText(staff.getPosition().getName());
            wage_amount.setText("Rp "+formattedNumber);
            wage_type.setText(items.get(0)+" "+items.get(1));
            address_street1.setText(staff.getLocation().getAddress().getStreet_1());
            if(session.isClockIn()){
                clock_in.setText(session.getClockIn());
                btn_clock.setText(R.string.clock_out);
            }
            if(session.isClockOut()){
                clock_out.setText(session.getClockOut());
                btn_background.setVisibility(View.GONE);
                btn_clock.setVisibility(View.GONE);
            }
//            manager_name.setText(staff.getManager().getName());
//            manager_phone.setText(staff.getManager().getPhone());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        session.clearSession();
        finish();
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
}
