package com.example.chartview.fragment;

import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chartview.R;
import com.hwc.chart.BaseChartView;
import com.hwc.chart.CurveChartView;

import java.util.ArrayList;
import java.util.List;



/**
 * 时间：2017/8/16
 * 作者：黄伟才
 * 简书：http://www.jianshu.com/p/87e7392a16ff
 * github：https://github.com/huangweicai/OkLibDemo
 * 描述：
 */

public class CurveChartFragment extends Fragment {
    private CurveChartView chartView1;
    private CurveChartView chartView2;
    private CurveChartView chartView3;
    private CurveChartView chartView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_curvechart, null, false);
        chartView1 = (CurveChartView) view.findViewById(R.id.weightChart1);
        chartView2 = (CurveChartView) view.findViewById(R.id.weightChart2);
        chartView3 = (CurveChartView) view.findViewById(R.id.weightChart3);
        chartView4 = (CurveChartView) view.findViewById(R.id.weightChart4);

        List<BaseChartView.DataBean> list = getDayData();
        chartView1
                .seMaxLineColor(0xffff0000)
                .setMaxTextColor(0xffff0000)
                .setAvgLineColor(0xff00ff00)
                .setAvgTextColor(0xff00ff00)
                .setMinLineColor(0xff0000ff)
                .setMinTextColor(0xff0000ff)
                .setLineWidht(10)//以上子类内容，必须写在下面方法上面
                .isShowDatumLine_X(false)
                .isShowDatumLine_Y(false)
                .setType(BaseChartView.DAY)
                .setYMaxValue(220)
                .setUnitValueText("bpm")
                .refreshData(list);
        chartView1.setOnDrawListener(new CurveChartView.OnDrawListener() {
            @Override
            public void onDraw(Canvas canvas) {
                chartView1.drawData(canvas);
            }
        });
        return view;
    }

    public void showChart() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                chartView2
                        .seMaxLineColor(0x00ff0000)
                        .setMaxTextColor(0x00ff0000)
                        .setAvgLineColor(0x0000ff00)
                        .setAvgTextColor(0x0000ff00)
                        .setMinLineColor(0xff0000ff)
                        .setMinTextColor(0xff0000ff)
                        .setLineWidht(10)//以上子类内容，必须写在下面方法上面
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.WEEK)
                        .setYMaxValue(220)
                        .setUnitValueText("bpm")
                        .setChartColor(0x00000000)
                        .refreshData(getWeekData());
                chartView3
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.MONTH)
                        .setYMaxValue(220)
                        .setUnitValueText("bpm")
                        .refreshData(getMonthData());
                chartView4
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.YEAR)
                        .setYMaxValue(220)
                        .setUnitValueText("bpm")
                        .refreshData(getYearData());
            }
        }, 800);
    }

    private List<BaseChartView.DataBean> getDayData() {
        //日数据源
        List<BaseChartView.DataBean> datas1 = new ArrayList<>();
        datas1.add(new BaseChartView.DataBean("2017-08-04 00:17:00", 80f, 64f, 40f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 06:17:00", 122f, 98f, 70f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 12:17:00", 86f, 58f, 30f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 18:17:00", 108f, 88f, 67f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 24:17:00", 92f, 78f, 50f));
        return datas1;
    }

    private List<BaseChartView.DataBean> getWeekData() {
        //周数据源
        List<BaseChartView.DataBean> datas2 = new ArrayList<>();
//        datas2.add(new BaseChartView.DataBean("2017-08-21 16:17:00", 80f, 64f, 40f));
//        datas2.add(new BaseChartView.DataBean("2017-08-22 16:17:00", 122f, 98f, 70f));
//        datas2.add(new BaseChartView.DataBean("2017-08-23 16:17:00", 86f, 58f, 30f));
//        datas2.add(new BaseChartView.DataBean("2017-08-24 16:17:00", 108f, 88f, 67f));
//        datas2.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 92f, 78f, 50f));
//        datas2.add(new BaseChartView.DataBean("2017-08-26 16:17:00", 112f, 98f, 80f));
        datas2.add(new BaseChartView.DataBean("2017-09-04 16:17:00", 80f, 0, 0));
        datas2.add(new BaseChartView.DataBean("2017-09-05 16:17:00", 90f, 0, 0));
        datas2.add(new BaseChartView.DataBean("2017-09-06 16:17:00", 100f, 0, 0));
        datas2.add(new BaseChartView.DataBean("2017-09-07 16:17:00", 111f, 0, 0));
        datas2.add(new BaseChartView.DataBean("2017-09-08 16:17:00", 120f, 0, 0));
        datas2.add(new BaseChartView.DataBean("2017-09-09 16:17:00", 130f, 0, 0));
        return datas2;
    }

    private List<BaseChartView.DataBean> getMonthData() {
        //月数据源
        List<BaseChartView.DataBean> datas3 = new ArrayList<>();
        datas3.add(new BaseChartView.DataBean("2017-08-01 16:17:00", 80f, 64f, 40f));
        datas3.add(new BaseChartView.DataBean("2017-08-05 16:17:00", 122f, 98f, 70f));
        datas3.add(new BaseChartView.DataBean("2017-08-10 16:17:00", 86f, 58f, 30f));
        datas3.add(new BaseChartView.DataBean("2017-08-15 16:17:00", 108f, 88f, 67f));
        datas3.add(new BaseChartView.DataBean("2017-08-20 16:17:00", 92f, 78f, 50f));
        datas3.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 112f, 98f, 80f));
        datas3.add(new BaseChartView.DataBean("2017-08-30 16:17:00", 132f, 112f, 99f));
        return datas3;
    }

    private List<BaseChartView.DataBean> getYearData() {
        //年数据源
        List<BaseChartView.DataBean> datas4 = new ArrayList<>();
        datas4.add(new BaseChartView.DataBean("2017-01-01 16:17:00", 80f, 64f, 40f));
        datas4.add(new BaseChartView.DataBean("2017-02-03 16:17:00", 122f, 98f, 70f));
        datas4.add(new BaseChartView.DataBean("2017-03-03 16:17:00", 86f, 58f, 30f));
        datas4.add(new BaseChartView.DataBean("2017-06-06 16:17:00", 108f, 88f, 67f));
        datas4.add(new BaseChartView.DataBean("2017-09-09 16:17:00", 112f, 98f, 80f));
        datas4.add(new BaseChartView.DataBean("2017-12-12 16:17:00", 132f, 112f, 99f));
        return datas4;
    }
}
