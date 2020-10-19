package com.cn.atguigu.DesignPattern.adapter.classadapter;

//????????
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

	@Override
	public int output5V() {
		// TODO Auto-generated method stub
		//?????220V???
		int srcV = output220V();
		int dstV = srcV / 44 ; //??? 5v
		return dstV;
	}

}
