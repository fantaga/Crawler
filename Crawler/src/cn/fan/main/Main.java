package cn.fan.main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) {
		HashSet<String> urls = CrawlerURL.fetchURLs("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", CrawlerURL.TYPE_ALL);
		
		try {
			DownLoad d = new DownLoad(new URL("https://matrix.dean.swust.edu.cn/cas/login?service=https%3A%2F%2Fmatrix%2Edean%2Eswust%2Eedu%2Ecn%2FacadmicManager%2Findex%2Ecfm%3Fevent%3DstudentPortal%3ADEFAULT_EVENT"));
			d.downLaod();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
