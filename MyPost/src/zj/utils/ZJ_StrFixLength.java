package zj.utils;

public class ZJ_StrFixLength {
	public static String getFixLengthStr(String str, int length,
			String placeholder) {
		if (null == str) {
			return str;
		} else if (str.length() > length) {
			return str.substring(0, length);
		} else {
			String temp = "";
			for (int i = 0; i < length - str.length(); i++) {
				temp += placeholder;
			}
			return str += temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(getFixLengthStr("dsadfgf", 10, "-"));
	}

}
