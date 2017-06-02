package com.yiqivr.calendarselector.lib;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.yiqivr.calendarselector.R;
import com.yiqivr.calendarselector.lib.CalendarListAdapter.OnCalendarOrderListener;

import java.util.List;

/**
 * @author lvning
 * @version create time:2014-10-29_上午9:56:45
 * @Description 预订日选择
 */
public class CalendarSelectorActivity extends Activity {

	/**
	 * 可选天数
	 */
	public static final String DAYS_OF_SELECT = "days_of_select";
	/**
	 * 上次预订日
	 */
	public static final String ORDER_DAY = "order_day";

	/**
	 * 显示的日期数目
	 */
	private int daysOfSelect;
	/**
	 * 已经被选择的天数
	 */
	private List<String> orderDay;

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendar_selector);
		daysOfSelect = getIntent().getIntExtra(DAYS_OF_SELECT, 0);
		orderDay = getIntent().getStringArrayListExtra(ORDER_DAY);
		listView = (ListView) findViewById(R.id.lv_calendar);

		final CalendarListAdapter adapter = new CalendarListAdapter(this, daysOfSelect, orderDay);
		listView.setAdapter(adapter);

		adapter.setOnCalendarOrderListener(new OnCalendarOrderListener() {

			@Override
			public void onOrder(String orderInfo) {
				Log.e("tag","被点击的日期="+orderInfo);
				if(orderDay.contains(orderInfo)){
					Toast.makeText(getApplicationContext(),"该天已经被预约",Toast.LENGTH_SHORT).show();
					orderDay.remove(orderInfo);
					adapter.notifyDataSetChanged();
				}else{
					orderDay.add(orderInfo);
					adapter.notifyDataSetChanged();
				}
				/*Intent result = new Intent();
				result.putExtra(ORDER_DAY, orderInfo);
				setResult(RESULT_OK, result);
				finish();*/
			}
		});

	}
}
