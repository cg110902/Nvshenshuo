package com.handmark.pulltorefresh.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	@SuppressLint("SimpleDateFormat")
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");

	public static String formatDateTime(long time) {
		if (0 == time) {
			return "";
		}
		return dateFormat.format(new Date(time));
	}

	public static String getMIEI(Context context) {
		TelephonyManager telephonemanage = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonemanage.getDeviceId();
	}

}
