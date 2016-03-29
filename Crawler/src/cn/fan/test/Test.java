package cn.fan.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.4399.com");
			URLConnection conn = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection)conn;
			//int code = connection.getResponseCode();
/*			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			// HttpURLConnection的connect()函数，实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。 
			connection.setRequestProperty("Content-type", "text/html");
			
			connection.setRequestMethod("GET");
			
			connection.setConnectTimeout(3000);*/
			
			//connection.connect();
			Map<String ,List<String> > req = connection.getRequestProperties();
			
			System.out.println(connection.getRequestMethod());
			/*Map<String, List<String>> map = connection.getHeaderFields();
			
			for(Map.Entry<String, List<String>> entry: map.entrySet())
			{
				String key = entry.getKey();
				System.out.println(key + ":" );
				List<String> values = entry.getValue();
				for(String value : values)
				{
					System.out.print(value + " ");
				}
				System.out.println();
			}*/
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
