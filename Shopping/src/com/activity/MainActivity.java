package com.activity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends TabActivity {

	RadioButton t1, t2, t3, t4;
	private static TabHost tabHost;
	private static Context context;
	// private TextView main_tab_new_message;
	// private static RadioButton main_tab_myExam;
	TabHost.TabSpec spec;
	Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		context = this;

		t1 = (RadioButton) findViewById(R.id.tab_rb_1);
		t2 = (RadioButton) findViewById(R.id.tab_rb_2);
		t3 = (RadioButton) findViewById(R.id.tab_rb_3);
		t4 = (RadioButton) findViewById(R.id.tab_rb_4);

		tabHost = this.getTabHost();

		intent = new Intent().setClass(this, IndexActivity.class);
		spec = tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ShopsActivity.class);
		spec = tabHost.newTabSpec("联系商家").setIndicator("联系商家")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, BuyActivity.class).addFlags(
				Intent.FLAG_ACTIVITY_CLEAR_TOP);
		spec = tabHost.newTabSpec("购物车").setIndicator("购物车").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, UserActivity.class);
		spec = tabHost.newTabSpec("个人中心").setIndicator("个人中心").setContent(intent);
		tabHost.addTab(spec);
		tabHost.setCurrentTab(0);

		RadioGroup radioGroup = (RadioGroup) this
				.findViewById(R.id.tab_rg_menu);

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				setRadioColor();
				switch (checkedId) {
				case R.id.tab_rb_1:// 添加考试
					t1.setTextColor(Color.rgb(248, 78, 1));
					tabHost.setCurrentTabByTag("首页");
					break;
				case R.id.tab_rb_2:// 我的考试
					t2.setTextColor(Color.rgb(248, 78, 1));
					tabHost.setCurrentTabByTag("联系商家");
					break;
				case R.id.tab_rb_3:// 我的通知
					t3.setTextColor(Color.rgb(248, 78, 1));
					tabHost.setCurrentTabByTag("购物车");
					break;
				case R.id.tab_rb_4:// 设置
					t4.setTextColor(Color.rgb(248, 78, 1));
					tabHost.setCurrentTabByTag("个人中心");
					break;
				default:
					// tabHost.setCurrentTabByTag("我的考试");
					break;
				}
			}
		});
	}

	private void setRadioColor() {
		t1.setTextColor(Color.rgb(142, 142, 142));
		t2.setTextColor(Color.rgb(142, 142, 142));
		t3.setTextColor(Color.rgb(142, 142, 142));
		t4.setTextColor(Color.rgb(142, 142, 142));

	}
}