package br.edu.fatec.okonesports.util;

import java.util.Calendar;

public class CalendarUtils {

	public static Calendar parseStringToCalendar(String calendar) {
		if (calendar == null || calendar.equals("")) {
			return null;
		}
		try {
			String[] stripCalendar = calendar.split("/");
			if (stripCalendar.length > 1) {
				Calendar cal = Calendar.getInstance();
				cal.setLenient(false);
				cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(stripCalendar[0]));
				cal.set(Calendar.MONTH, Integer.parseInt(stripCalendar[1]) - 1);
				cal.set(Calendar.YEAR, Integer.parseInt(stripCalendar[2]));
				return cal;
			}
			stripCalendar = calendar.split("-");
			Calendar cal = Calendar.getInstance();
			cal.setLenient(false);
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(stripCalendar[2]));
			cal.set(Calendar.MONTH, Integer.parseInt(stripCalendar[1]) - 1);
			cal.set(Calendar.YEAR, Integer.parseInt(stripCalendar[0]));
			return cal;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String formatCalendarToString(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		sb.append((day < 10 ? "0" + day : day) + "/");
		sb.append((month < 10 ? "0" + month : month) + "/");
		sb.append(year);
		return sb.toString();
	}

	public static String formatTimeToString(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		calendar.setLenient(false);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		sb.append((hour < 10 ? "0" + hour : hour) + ":");
		sb.append((minute < 10 ? "0" + minute : minute) + ":");
		sb.append(second < 10 ? "0" + second : second);
		return sb.toString();
	}

}