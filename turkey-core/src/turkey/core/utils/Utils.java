package turkey.core.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"YYMMddHHmmss");
	public static final String CONNECT_STR = ";";

	public static String formatDate() {
		return dateFormat.format(new Date());
	}

	public static String getCommitId() {
		try {
			String localName = InetAddress.getLocalHost().getHostName();
			String localIp = InetAddress.getLocalHost().getHostAddress();
			return localName + CONNECT_STR + localIp + CONNECT_STR
					+ System.currentTimeMillis();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void main(String[] args) {
//		System.out.println(getCommitId());
//	}
}
