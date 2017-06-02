package com.yiqivr.calendarselector.lib;

/**
 * @author lvning
 * @version create time:2014-10-29_下午3:29:43
 * @Description TODO
 */
public class Day {

	public Day(String name, DayType type, boolean isOrdered) {
		setName(name);
		setType(type);
		setOrdered(isOrdered);
	}

	public enum DayType {
		//今天   明天       后天   可以点击的   不能点击的
		TODAY, TOMORROW, T_D_A_T, ENABLE, NOT_ENABLE
	}

	private String name;//日期 号数
	private DayType type;//类型
	private boolean isOrdered;//是否已选择

	public boolean isOrdered() {
		return isOrdered;
	}

	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DayType getType() {
		return type;
	}

	public void setType(DayType type) {
		this.type = type;
	}
}
