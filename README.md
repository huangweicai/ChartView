>前言：最近公司这边项目新版本界面大改动，以前版本都是使用MPAndroidChart来实现的图表，这次UI界面需求设计个性化比较强，只好把以前所有的图表重新设计实现一遍，花了一天分析设计结构及抽取共用模块，一天实现图表的数据填充及图表效果绘制，一天优化图表代码及图表行为属性暴露。如下图，图表的使用样例已经上传到github，有需要的朋友可以借鉴。

>体验apk：[https://fir.im/6sf2](https://fir.im/6sf2)
github图表使用演示地址：[https://github.com/huangweicai/chart](https://github.com/huangweicai/chart)
快捷使用：compile 'me.hwc:chart:1.0.1'

>欢迎关注oklib，后面图表的所有源码都会集成到oklib库中[http://www.jianshu.com/p/87e7392a16ff](http://www.jianshu.com/p/87e7392a16ff)

![图表演示](http://upload-images.jianshu.io/upload_images/2405826-a7f4ff06d39a39c1.GIF?imageMogr2/auto-orient/strip)


#####折线图：
```
public class LineChartFragment extends Fragment {
    private LineChartView chartView1;
    private LineChartView chartView2;
    private LineChartView chartView3;
    private LineChartView chartView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight_chart, null, false);
        chartView1 = (LineChartView) view.findViewById(R.id.weightChart1);
        chartView2 = (LineChartView) view.findViewById(R.id.weightChart2);
        chartView3 = (LineChartView) view.findViewById(R.id.weightChart3);
        chartView4 = (LineChartView) view.findViewById(R.id.weightChart4);
        return view;
    }

    public void showChart() {
        //注意：图表使用一定要延迟使用
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chartView1
                        .setLineColor(0xffff0000)
                        .setTextColor(0xff0000ff)
                        .setCircleColor(0xff00ff00)
                        .setTextSize(24)
                        .setCircleRadiusSize(14)
                        .setLineSize(10)//以上子类内容，必须写在下面方法上面
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.DAY)
                        .setYMaxValue(150)
                        .setUnitValueText("Kg")
                        .refreshData(getDayData());
                chartView2
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.WEEK)
                        .setYMaxValue(150)
                        .setUnitValueText("Kg")
                        .refreshData(getWeekData());
                chartView3
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.MONTH)
                        .setYMaxValue(150)
                        .setUnitValueText("Kg")
                        .refreshData(getMonthData());
                chartView4
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.YEAR)
                        .setYMaxValue(150)
                        .setUnitValueText("Kg")
                        .refreshData(getYearData());
            }
        }, 800);
    }

    private List<BaseChartView.DataBean> getDayData() {
        //日数据源
        List<BaseChartView.DataBean> datas1 = new ArrayList<>();
        datas1.add(new BaseChartView.DataBean("2017-08-04 00:17:00", 60f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 06:17:00", 122f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 12:17:00", 86f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 18:17:00", 108f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 24:17:00", 92f));
        datas1.add(new BaseChartView.DataBean("20170804 241700", 92f));
        return datas1;
    }

    private List<BaseChartView.DataBean> getWeekData() {
        //周数据源
        List<BaseChartView.DataBean> datas2 = new ArrayList<>();
        datas2.add(new BaseChartView.DataBean("2017-08-21 16:17:00", 60f));
        datas2.add(new BaseChartView.DataBean("2017-08-22 16:17:00", 86f));
        datas2.add(new BaseChartView.DataBean("2017-08-23 16:17:00", 86f));
        datas2.add(new BaseChartView.DataBean("2017-08-24 16:17:00", 68f));
        datas2.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 72f));
        datas2.add(new BaseChartView.DataBean("2017-08-26 16:17:00", 112f));
        return datas2;
    }

    private List<BaseChartView.DataBean> getMonthData() {
        //月数据源
        List<BaseChartView.DataBean> datas3 = new ArrayList<>();
        datas3.add(new BaseChartView.DataBean("2017-08-01 16:17:00", 60f));
        datas3.add(new BaseChartView.DataBean("2017-08-05 16:17:00", 116f));
        datas3.add(new BaseChartView.DataBean("2017-08-10 16:17:00", 98f));
        datas3.add(new BaseChartView.DataBean("2017-08-15 16:17:00", 52f));
        datas3.add(new BaseChartView.DataBean("2017-08-20 16:17:00", 102f));
        datas3.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 82f));
        datas3.add(new BaseChartView.DataBean("2017-08-30 16:17:00", 132f));
        return datas3;
    }

    private List<BaseChartView.DataBean> getYearData() {
        //年数据源
        List<BaseChartView.DataBean> datas4 = new ArrayList<>();
        datas4.add(new BaseChartView.DataBean("2017-01-01 16:17:00", 60f));
        datas4.add(new BaseChartView.DataBean("2017-02-03 16:17:00", 116f));
        datas4.add(new BaseChartView.DataBean("2017-03-03 16:17:00", 86f));
        datas4.add(new BaseChartView.DataBean("2017-06-06 16:17:00", 72f));
        datas4.add(new BaseChartView.DataBean("2017-09-09 16:17:00", 122f));
        datas4.add(new BaseChartView.DataBean("2017-12-12 16:17:00", 82f));
        return datas4;
    }
}
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#60bf8d"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="体重，自然日，单位Kg" />

            <com.hwc.chart.LineChartView
                android:id="@+id/weightChart1"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="体重，自然周，单位Kg" />

            <com.hwc.chart.LineChartView
                android:id="@+id/weightChart2"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="体重，自然月，单位Kg" />

            <com.hwc.chart.LineChartView
                android:id="@+id/weightChart3"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="体重，自然年，单位Kg" />

            <com.hwc.chart.LineChartView
                android:id="@+id/weightChart4"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

        </LinearLayout>
    </ScrollView>

</LinearLayout>
```

#####曲线图：
```
public class CurveChartFragment extends Fragment {
    private CurveChartView chartView1;
    private CurveChartView chartView2;
    private CurveChartView chartView3;
    private CurveChartView chartView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate_chart, null, false);
        chartView1 = (CurveChartView) view.findViewById(R.id.weightChart1);
        chartView2 = (CurveChartView) view.findViewById(R.id.weightChart2);
        chartView3 = (CurveChartView) view.findViewById(R.id.weightChart3);
        chartView4 = (CurveChartView) view.findViewById(R.id.weightChart4);
        return view;
    }

    public void showChart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
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
                        .refreshData(getDayData());
                chartView2
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.WEEK)
                        .setYMaxValue(220)
                        .setUnitValueText("bpm")
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
        datas2.add(new BaseChartView.DataBean("2017-08-21 16:17:00", 80f, 64f, 40f));
        datas2.add(new BaseChartView.DataBean("2017-08-22 16:17:00", 122f, 98f, 70f));
        datas2.add(new BaseChartView.DataBean("2017-08-23 16:17:00", 86f, 58f, 30f));
        datas2.add(new BaseChartView.DataBean("2017-08-24 16:17:00", 108f, 88f, 67f));
        datas2.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 92f, 78f, 50f));
        datas2.add(new BaseChartView.DataBean("2017-08-26 16:17:00", 112f, 98f, 80f));
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
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#54a5ef"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="心率，自然日，单位bpm" />

            <com.hwc.chart.CurveChartView
                android:id="@+id/weightChart1"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="心率，自然周，单位bpm" />

            <com.hwc.chart.CurveChartView
                android:id="@+id/weightChart2"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="心率，自然月，单位bpm" />

            <com.hwc.chart.CurveChartView
                android:id="@+id/weightChart3"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="心率，自然年，单位bpm" />

            <com.hwc.chart.CurveChartView
                android:id="@+id/weightChart4"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

        </LinearLayout>
    </ScrollView>

</LinearLayout>
```

#####柱状图：
```
public class BarChartFragment extends Fragment {
    private BarChartView chartView1;
    private BarChartView chartView2;
    private BarChartView chartView3;
    private BarChartView chartView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport_chart, null, false);
        chartView1 = (BarChartView) view.findViewById(R.id.weightChart1);
        chartView2 = (BarChartView) view.findViewById(R.id.weightChart2);
        chartView3 = (BarChartView) view.findViewById(R.id.weightChart3);
        chartView4 = (BarChartView) view.findViewById(R.id.weightChart4);
        return view;
    }

    public void showChart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chartView1
                        .setPillarWidth(30f)
                        .setPillarColor(0x90ff0000)//以上子类内容，必须写在下面方法上面
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.DAY)
                        .setYMaxValue(30)
                        .setUnitValueText("Km")
                        .refreshData(getDayData());
                chartView2
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.WEEK)
                        .setYMaxValue(30)
                        .setUnitValueText("Km")
                        .refreshData(getWeekData());
                chartView3
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.MONTH)
                        .setYMaxValue(30)
                        .setUnitValueText("Km")
                        .refreshData(getMonthData());
                chartView4
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.YEAR)
                        .setYMaxValue(30)
                        .setUnitValueText("Km")
                        .refreshData(getYearData());
            }
        }, 800);
    }

    private List<BaseChartView.DataBean> getDayData() {
        //日数据源
        List<BaseChartView.DataBean> datas1 = new ArrayList<>();
        datas1.add(new BaseChartView.DataBean("2017-08-04 00:17:00", 5f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 06:17:00", 12f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 12:17:00", 6f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 18:17:00", 18f));
        datas1.add(new BaseChartView.DataBean("2017-08-04 24:17:00", 12f));
        return datas1;
    }

    private List<BaseChartView.DataBean> getWeekData() {
        //周数据源
        List<BaseChartView.DataBean> datas2 = new ArrayList<>();
        datas2.add(new BaseChartView.DataBean("2017-08-21 16:17:00", 6f));
        datas2.add(new BaseChartView.DataBean("2017-08-22 16:17:00", 16f));
        datas2.add(new BaseChartView.DataBean("2017-08-23 16:17:00", 3f));
        datas2.add(new BaseChartView.DataBean("2017-08-24 16:17:00", 18f));
        datas2.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 12f));
        datas2.add(new BaseChartView.DataBean("2017-08-26 16:17:00", 22f));
        return datas2;
    }

    private List<BaseChartView.DataBean> getMonthData() {
        //月数据源
        List<BaseChartView.DataBean> datas3 = new ArrayList<>();
        datas3.add(new BaseChartView.DataBean("2017-08-01 16:17:00", 6f));
        datas3.add(new BaseChartView.DataBean("2017-08-05 16:17:00", 16f));
        datas3.add(new BaseChartView.DataBean("2017-08-10 16:17:00", 8f));
        datas3.add(new BaseChartView.DataBean("2017-08-15 16:17:00", 2f));
        datas3.add(new BaseChartView.DataBean("2017-08-20 16:17:00", 12f));
        datas3.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 22f));
        datas3.add(new BaseChartView.DataBean("2017-08-30 16:17:00", 13f));
        return datas3;
    }

    private List<BaseChartView.DataBean> getYearData() {
        //年数据源
        List<BaseChartView.DataBean> datas4 = new ArrayList<>();
        datas4.add(new BaseChartView.DataBean("2017-01-01 16:17:00", 6f));
        datas4.add(new BaseChartView.DataBean("2017-02-03 16:17:00", 16f));
        datas4.add(new BaseChartView.DataBean("2017-03-03 16:17:00", 8f));
        datas4.add(new BaseChartView.DataBean("2017-06-06 16:17:00", 2f));
        datas4.add(new BaseChartView.DataBean("2017-09-09 16:17:00", 12f));
        datas4.add(new BaseChartView.DataBean("2017-12-12 16:17:00", 22f));
        return datas4;
    }
}
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#f8973d"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="运动，自然日，单位Km" />

            <com.hwc.chart.BarChartView
                android:id="@+id/weightChart1"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="运动，自然周，单位Km" />

            <com.hwc.chart.BarChartView
                android:id="@+id/weightChart2"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="运动，自然月，单位Km" />

            <com.hwc.chart.BarChartView
                android:id="@+id/weightChart3"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="运动，自然年，单位Km" />

            <com.hwc.chart.BarChartView
                android:id="@+id/weightChart4"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

        </LinearLayout>
    </ScrollView>

</LinearLayout>
```

#####镂空柱状图：
```
public class HistogramBarChartFragment extends Fragment {
    private HistogramBarChartView chartView1;
    private HistogramBarChartView chartView2;
    private HistogramBarChartView chartView3;
    private HistogramBarChartView chartView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blood_chart, null, false);
        chartView1 = (HistogramBarChartView) view.findViewById(R.id.weightChart1);
        chartView2 = (HistogramBarChartView) view.findViewById(R.id.weightChart2);
        chartView3 = (HistogramBarChartView) view.findViewById(R.id.weightChart3);
        chartView4 = (HistogramBarChartView) view.findViewById(R.id.weightChart4);
        return view;
    }

    public void showChart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chartView1
                        .setNoMedicineColor(0xffff0000)
                        .setMedicineColor(0xff00ff00)
                        .setNoMedicineText("未打针")
                        .setMedicineText("打针")
                        .setBloodText("高针114-128/低针68-78")
                        .setPillarWidth(26f)//以上子类内容，必须写在下面方法上面
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.DAY)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getDayData());

                chartView2
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.WEEK)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getWeekData());
                chartView3
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.MONTH)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getMonthData());
                chartView4
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.YEAR)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getYearData());
            }
        }, 800);
    }

    private List<BaseChartView.DataBean> getDayData() {
        //日数据源
        List<BaseChartView.DataBean> datas1 = new ArrayList<>();
        datas1.add(new BaseChartView.DataBean("2017-08-04 00:17:00", 60f, 30f, false));
        datas1.add(new BaseChartView.DataBean("2017-08-04 06:17:00", 122f, 60f, false));
        datas1.add(new BaseChartView.DataBean("2017-08-04 12:17:00", 86f, 40f, true));
        datas1.add(new BaseChartView.DataBean("2017-08-04 18:17:00", 108f, 80f, false));
        datas1.add(new BaseChartView.DataBean("2017-08-04 24:17:00", 92f, 10f, true));
        return datas1;
    }

    private List<BaseChartView.DataBean> getWeekData() {
        //周数据源
        List<BaseChartView.DataBean> datas2 = new ArrayList<>();
        datas2.add(new BaseChartView.DataBean("2017-08-21 16:17:00", 60f, 40f, true));
        datas2.add(new BaseChartView.DataBean("2017-08-22 16:17:00", 86f, 70f, false));
        datas2.add(new BaseChartView.DataBean("2017-08-23 16:17:00", 86f, 20f, true));
        datas2.add(new BaseChartView.DataBean("2017-08-24 16:17:00", 68f, 30f, false));
        datas2.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 72f, 33f, true));
        datas2.add(new BaseChartView.DataBean("2017-08-26 16:17:00", 112f, 60f, true));
        datas2.add(new BaseChartView.DataBean("2017-08-27 16:17:00", 122f, 80f, true));
        return datas2;
    }

    private List<BaseChartView.DataBean> getMonthData() {
        //月数据源
        List<BaseChartView.DataBean> datas3 = new ArrayList<>();
        datas3.add(new BaseChartView.DataBean("2017-08-01 16:17:00", 60f, 40f, false));
        datas3.add(new BaseChartView.DataBean("2017-08-05 16:17:00", 116f, 92f, true));
        datas3.add(new BaseChartView.DataBean("2017-08-10 16:17:00", 98f, 70f, true));
        datas3.add(new BaseChartView.DataBean("2017-08-15 16:17:00", 52f, 30f, false));
        datas3.add(new BaseChartView.DataBean("2017-08-20 16:17:00", 102f, 20f, true));
        datas3.add(new BaseChartView.DataBean("2017-08-25 16:17:00", 82f, 60f, true));
        datas3.add(new BaseChartView.DataBean("2017-08-30 16:17:00", 132f, 110f, true));
        return datas3;
    }

    private List<BaseChartView.DataBean> getYearData() {
        //年数据源
        List<BaseChartView.DataBean> datas4 = new ArrayList<>();
        datas4.add(new BaseChartView.DataBean("2017-01-01 16:17:00", 60f, 30f, true));
        datas4.add(new BaseChartView.DataBean("2017-02-03 16:17:00", 116f, 100f, false));
        datas4.add(new BaseChartView.DataBean("2017-03-03 16:17:00", 86f, 33f, false));
        datas4.add(new BaseChartView.DataBean("2017-06-06 16:17:00", 72f, 20f, true));
        datas4.add(new BaseChartView.DataBean("2017-09-09 16:17:00", 122f, 85f, false));
        datas4.add(new BaseChartView.DataBean("2017-12-12 16:17:00", 82f, 60f, true));
        return datas4;
    }
}
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#f074af"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然日，单位mmHg" />

            <com.hwc.chart.HistogramBarChartView
                android:id="@+id/weightChart1"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然周，单位mmHg" />

            <com.hwc.chart.HistogramBarChartView
                android:id="@+id/weightChart2"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然月，单位mmHg" />

            <com.hwc.chart.HistogramBarChartView
                android:id="@+id/weightChart3"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然年，单位mmHg" />

            <com.hwc.chart.HistogramBarChartView
                android:id="@+id/weightChart4"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

        </LinearLayout>
    </ScrollView>

</LinearLayout>
```
#####定制血压图：
```
public class CustomizedBloodChartFragment extends Fragment {
    private CustomizedBloodChartView chartView1;
    private CustomizedBloodChartView chartView2;
    private CustomizedBloodChartView chartView3;
    private CustomizedBloodChartView chartView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blood_chart_, null, false);
        chartView1 = (CustomizedBloodChartView) view.findViewById(R.id.weightChart1);
        chartView2 = (CustomizedBloodChartView) view.findViewById(R.id.weightChart2);
        chartView3 = (CustomizedBloodChartView) view.findViewById(R.id.weightChart3);
        chartView4 = (CustomizedBloodChartView) view.findViewById(R.id.weightChart4);
        return view;
    }

    public void showChart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chartView1
                        .setNoMedicineColor(0xffff0000)
                        .setMedicineColor(0xff00ff00)
                        .setNoMedicineText("未打针")
                        .setMedicineText("打针")
                        .setBloodText("高针114-128/低针68-78")
                        .setMedicineScaleColor(0x900000ff)
                        .setNoMedicineScaleColor(0x9000ffff)
                        .setPillarWidth(26f)//以上子类内容，必须写在下面方法上面
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.DAY)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getDayData());
                chartView2
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.WEEK)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getWeekData());
                chartView3
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.MONTH)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getMonthData());
                chartView4
                        .isShowDatumLine_X(false)
                        .isShowDatumLine_Y(false)
                        .setType(BaseChartView.YEAR)
                        .setYMaxValue(240)
                        .setUnitValueText("mmHg")
                        .refreshData(getYearData());
            }
        }, 800);
    }

    private List<BaseChartView.DataBean> getDayData() {
        //日数据源
        List<BaseChartView.DataBean> datas1 = new ArrayList<>();//高压最高、高压最低，低压最高、低压最低
        datas1.add(new BaseChartView.DataBean("2017-08-04 00:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, false));
        datas1.add(new BaseChartView.DataBean("2017-08-04 06:17:00", new float[]{108f, 87f}, new float[]{73f, 57f}, false));
        datas1.add(new BaseChartView.DataBean("2017-08-04 12:17:00", new float[]{88f, 67f}, new float[]{60f, 57f}, true));
        datas1.add(new BaseChartView.DataBean("2017-08-04 18:17:00", new float[]{120f, 117f}, new float[]{90f, 87f}, false));
        datas1.add(new BaseChartView.DataBean("2017-08-04 24:17:00", new float[]{110f, 97f}, new float[]{80f, 67f}, true));
        return datas1;
    }

    private List<BaseChartView.DataBean> getWeekData() {
        //周数据源
        List<BaseChartView.DataBean> datas2 = new ArrayList<>();
        datas2.add(new BaseChartView.DataBean("2017-08-21 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas2.add(new BaseChartView.DataBean("2017-08-22 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, false));
        datas2.add(new BaseChartView.DataBean("2017-08-23 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas2.add(new BaseChartView.DataBean("2017-08-24 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, false));
        datas2.add(new BaseChartView.DataBean("2017-08-25 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas2.add(new BaseChartView.DataBean("2017-08-26 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        return datas2;
    }

    private List<BaseChartView.DataBean> getMonthData() {
        //月数据源
        List<BaseChartView.DataBean> datas3 = new ArrayList<>();
        datas3.add(new BaseChartView.DataBean("2017-08-01 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, false));
        datas3.add(new BaseChartView.DataBean("2017-08-05 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas3.add(new BaseChartView.DataBean("2017-08-10 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas3.add(new BaseChartView.DataBean("2017-08-15 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, false));
        datas3.add(new BaseChartView.DataBean("2017-08-20 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas3.add(new BaseChartView.DataBean("2017-08-25 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas3.add(new BaseChartView.DataBean("2017-08-30 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        return datas3;
    }

    private List<BaseChartView.DataBean> getYearData() {
        //年数据源
        List<BaseChartView.DataBean> datas4 = new ArrayList<>();
        datas4.add(new BaseChartView.DataBean("2017-01-01 16:17:00", new float[]{100f, 87f}, new float[]{80f, 67f}, true));
        datas4.add(new BaseChartView.DataBean("2017-02-03 16:17:00", new float[]{110f, 67f}, new float[]{50f, 37f}, false));
        datas4.add(new BaseChartView.DataBean("2017-03-03 16:17:00", new float[]{90f, 77f}, new float[]{60f, 47f}, false));
        datas4.add(new BaseChartView.DataBean("2017-06-06 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        datas4.add(new BaseChartView.DataBean("2017-09-09 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, false));
        datas4.add(new BaseChartView.DataBean("2017-12-12 16:17:00", new float[]{80f, 67f}, new float[]{50f, 37f}, true));
        return datas4;
    }
}
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#f074af"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然日，单位mmHg" />

            <com.hwc.chart.CustomizedBloodChartView
                android:id="@+id/weightChart1"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然周，单位mmHg" />

            <com.hwc.chart.CustomizedBloodChartView
                android:id="@+id/weightChart2"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然月，单位mmHg" />

            <com.hwc.chart.CustomizedBloodChartView
                android:id="@+id/weightChart3"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="血压，自然年，单位mmHg" />

            <com.hwc.chart.CustomizedBloodChartView
                android:id="@+id/weightChart4"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="@drawable/round_white_alpha" />

        </LinearLayout>
    </ScrollView>

</LinearLayout>
```

#####以上就是这次图表的所有内容，如果在使用过程中遇到问题或更好的建议，欢迎留言私信，作者将竭诚解决。最后，有帮助到您的欢迎点赞关注，您的支持是对作者最大的支持，谢谢！