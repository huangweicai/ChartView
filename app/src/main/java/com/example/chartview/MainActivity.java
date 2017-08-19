package com.example.chartview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chartview.fragment.BloodChartFragment;
import com.example.chartview.fragment.RateChartFragment;
import com.example.chartview.fragment.SportChartFragment;
import com.example.chartview.fragment.WeightChartFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_weight;
    private Button btn_blood;
    private Button btn_rate;
    private Button btn_sport;

    private FragmentManager fm;
    private FragmentTransaction ft;
    private WeightChartFragment weightChartFragment;
    private RateChartFragment rateChartFragment;
    private SportChartFragment sportChartFragment;
    private BloodChartFragment bloodChartFragment;

    @Override
    public void onClick(View v) {
        ft = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.btn_weight:
                ft.show(weightChartFragment);
                ft.hide(bloodChartFragment);
                ft.hide(rateChartFragment);
                ft.hide(sportChartFragment);
                weightChartFragment.showChart();

                btn_weight.setBackgroundColor(0x90ff0000);
                btn_blood.setBackgroundColor(0xf0f0f0);
                btn_rate.setBackgroundColor(0xf0f0f0);
                btn_sport.setBackgroundColor(0xf0f0f0);
                break;
            case R.id.btn_blood:
                ft.hide(weightChartFragment);
                ft.show(bloodChartFragment);
                ft.hide(rateChartFragment);
                ft.hide(sportChartFragment);
                bloodChartFragment.showChart();

                btn_weight.setBackgroundColor(0xf0f0f0);
                btn_blood.setBackgroundColor(0x90ff0000);
                btn_rate.setBackgroundColor(0xf0f0f0);
                btn_sport.setBackgroundColor(0xf0f0f0);
                break;
            case R.id.btn_rate:
                ft.hide(weightChartFragment);
                ft.hide(bloodChartFragment);
                ft.show(rateChartFragment);
                ft.hide(sportChartFragment);
                rateChartFragment.showChart();

                btn_weight.setBackgroundColor(0xf0f0f0);
                btn_blood.setBackgroundColor(0xf0f0f0);
                btn_rate.setBackgroundColor(0x90ff0000);
                btn_sport.setBackgroundColor(0xf0f0f0);
                break;
            case R.id.btn_sport:
                ft.hide(weightChartFragment);
                ft.hide(bloodChartFragment);
                ft.hide(rateChartFragment);
                ft.show(sportChartFragment);
                sportChartFragment.showChart();

                btn_weight.setBackgroundColor(0xf0f0f0);
                btn_blood.setBackgroundColor(0xf0f0f0);
                btn_rate.setBackgroundColor(0xf0f0f0);
                btn_sport.setBackgroundColor(0x90ff0000);
                break;
        }
        ft.commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_weight = (Button) findViewById(R.id.btn_weight);
        btn_blood = (Button) findViewById(R.id.btn_blood);
        btn_rate = (Button) findViewById(R.id.btn_rate);
        btn_sport = (Button) findViewById(R.id.btn_sport);
        btn_weight.setOnClickListener(this);
        btn_blood.setOnClickListener(this);
        btn_rate.setOnClickListener(this);
        btn_sport.setOnClickListener(this);

        weightChartFragment = new WeightChartFragment();
        rateChartFragment = new RateChartFragment();
        sportChartFragment = new SportChartFragment();
        bloodChartFragment = new BloodChartFragment();

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.fl_layout, weightChartFragment);
        ft.add(R.id.fl_layout, rateChartFragment);
        ft.add(R.id.fl_layout, sportChartFragment);
        ft.add(R.id.fl_layout, bloodChartFragment);
        ft.show(weightChartFragment);
        ft.hide(rateChartFragment);
        ft.hide(sportChartFragment);
        ft.hide(bloodChartFragment);
        ft.commitAllowingStateLoss();
    }

}
