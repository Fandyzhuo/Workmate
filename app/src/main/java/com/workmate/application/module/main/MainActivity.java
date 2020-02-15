package com.workmate.application.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.workmate.application.R;
import com.workmate.application.base.BaseActivity;
import com.workmate.application.model.Staff;
import com.workmate.application.module.clocking.ClockingActivity;
import com.workmate.application.module.main.pattern.MainDoPresenter;
import com.workmate.application.module.main.pattern.MainPresenter;
import com.workmate.application.module.main.pattern.MainView;
import com.workmate.application.utils.NetworkUtils;

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

    private MainPresenter mainPresenter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        getSupportActionBar().hide();
        mainPresenter = new MainDoPresenter(this, this);
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
            Log.i("MainActivity Isi", staff.getClient().getName());
            client_name.setText(staff.getClient().getName());
            position_name.setText(staff.getPosition().getName());
            wage_amount.setText("Rp "+staff.getWage_amount());
            wage_type.setText(staff.getWage_type());
            address_street1.setText(staff.getLocation().getAddress().getStreet_1());
//            manager_name.setText(staff.getManager().getName());
//            manager_phone.setText(staff.getManager().getPhone());
        }
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