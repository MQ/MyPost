package zj.utils;

public class ZJ_Num2Str {
	public static String num2str(int i) {
		return Integer.toString(i, 36);
	}

	public static int str2num(String s) {
		return Integer.parseInt(s, 16);
	}

	public static void main(String[] args) {
		System.out.println(str2num("aa"));
	}

}
