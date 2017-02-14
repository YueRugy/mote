package com.yue.enums;

public enum VideoTaskStatus {
	publish(1), // 报名
	selectMote(2), // 挑选模特
	cancel(3), // 被取消后台操作
	processing(4),//进行中
	determined(5),//待确定
	complete(6),//完成
	;

	private int code;

	VideoTaskStatus(int code) {
		this.code = code;
	}

	public int getValue() {
		return code;
	}

	public static boolean containStatus(int value){
		for (VideoTaskStatus status:VideoTaskStatus.values()) {
			if (status.getValue()==value){
				return true;
			}
		}
		return false;
	}



}
