package zj.github;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import zj.utils.ZJ_HttpXmlClient;
import zj.utils.ZJ_StrFixLength;

public class NameCreater {
	private static boolean iscanuse(String name) throws ClientProtocolException, IOException {
		Map<String, String> pars = new HashMap<String, String>();
		pars.put("value", name);
		String result = ZJ_HttpXmlClient.post("https://github.com/signup_check/username", pars);
		if ("".equals(result.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			FileWriter fw = new FileWriter("E:/github_1297-10000 .txt", true);
			pw = new PrintWriter(fw);
			pw.println("----------------------------------------");
			for (int j = 1297; j < 10000; j++) {
				String str = Integer.toString(j, 36);
				boolean b = false;
				try {
					b = iscanuse(str);
				} catch (Exception e) {
					pw.println(ZJ_StrFixLength.getFixLengthStr(j + ":" + str, 20, " ") + "??????");
					continue;
				}
				if (b) {
					pw.println(ZJ_StrFixLength.getFixLengthStr(j + ":" + str, 20, " ") + "√√");
				} else {
					pw.println(ZJ_StrFixLength.getFixLengthStr(j + ":" + str, 20, " ") + "×");
				}
				pw.flush();
			}
		} catch (Exception e) {
			pw.println("----------------------------------------");
		} finally {
			if (null != pw) {
				pw.flush();
				pw.close();
			}
		}

	}

}
