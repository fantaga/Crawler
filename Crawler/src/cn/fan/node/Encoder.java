package cn.fan.node;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Decoder;

import org.junit.Test;

public class Encoder {

	@Test
	public void test() throws IOException {
		
		URL url = new URL("https://matrix.dean.swust.edu.cn/cas/login?service=https%3A%2F%2Fmatrix%2Edean%2Eswust%2Eedu%2Ecn%2FacadmicManager%2Findex%2Ecfm%3Fevent%3DstudentPortal%3ADEFAULT_EVENT");
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		String deco = URLDecoder.decode("https://matrix.dean.swust.edu.cn/cas/login?service=https%3A%2F%2Fmatrix%2Edean%2Eswust%2Eedu%2Ecn%2FacadmicManager%2Findex%2Ecfm%3Fevent%3DstudentPortal%3ADEFAULT_EVENT", "utf-8");
		String deco2 = URLDecoder.decode("event=studentPortal:DEFAULT_EVENT&ticket=ST-556D2517-C4AC-17C3-DA5766B2D2F61379", "utf-8");
		System.out.println(deco);
		System.out.println(deco2);
	}

}
