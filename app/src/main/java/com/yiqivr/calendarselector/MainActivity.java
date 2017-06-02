package com.yiqivr.calendarselector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yiqivr.calendarselector.lib.CalendarSelectorActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {
	private ArrayList<String> orderDays = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		orderDays.add("2017#6#3");
		orderDays.add("2017#6#6");
		orderDays.add("2017#6#9");
		orderDays.add("2017#6#23");
	}

	public void jump(View v) {
		Intent i = new Intent(MainActivity.this, CalendarSelectorActivity.class);
		i.putExtra(CalendarSelectorActivity.DAYS_OF_SELECT, 40);//显示40天可被选择的日期
		i.putStringArrayListExtra(CalendarSelectorActivity.ORDER_DAY, orderDays);//被选中了的日期(已经被预约)
		startActivityForResult(i, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1 && resultCode == RESULT_OK) {
			String orderInfo = data.getStringExtra(CalendarSelectorActivity.ORDER_DAY);
			/* *****注意*****
			// 如需转换为Calendar
			// 正确转换方法（因为2月没有30天）：
			String[] info = orderInfo.split("#");
			Calendar c = Calendar.getInstance();
			c.set(Integer.valueOf(info[0]), Integer.valueOf(info[1]) - 1, Integer.valueOf(info[2]));
			// 错误转换方法：
			c.set(Integer.valueOf(info[0]), Integer.valueOf(info[1]), Integer.valueOf(info[2]));
			c.add(Calendar.MONTH, -1);
			**/
		}
	}

}
