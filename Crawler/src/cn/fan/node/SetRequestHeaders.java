package cn.fan.node;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class SetRequestHeaders {

	@Test
	public void test() throws IOException {
		URL url = new URL("https://www.baidu.com");
		HttpURLConnection connection = (HttpURLConnection)
											url.openConnection();
		
		
		Properties prop = new Properties();
		
		InputStream inStream = getClass().getResourceAsStream("requestconfig.properties");
		
		prop.load(inStream);
		
		
		Enumeration<?> e = prop.propertyNames();
/*		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}*/
		
/*		Iterator it = prop.entrySet().iterator();
		
		while(it.hasNext())
		{	
			Entry entry = (Entry) it.next();
			connection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
		}*/
		
/*		connection.setDoOutput(true);
		connection.setUseCaches(false);*/
		
		//connection.getOutputStream();
		Map<String, List<String>> req = connection.getRequestProperties();
		
		//InputStream in = connection.getInputStream();
		
		Map<String, List<String>> response = connection.getHeaderFields();
		System.out.println(connection.getHeaderField("Set-Cookie"));
		for(Map.Entry<String, List<String>> entry : response.entrySet())
		{
			String key = entry.getKey();
			System.out.print(key + " : ");
			List<String> values = entry.getValue();
			for(String value : values)
			{
				System.out.print(value);
			}
			System.out.printf("\n");
		}
/*		BufferedReader bufr = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			System.out.println(line);
		}*/
/*		for(Map.Entry<String, List<String>> entry : req.entrySet())
		{
			System.out.print(entry.getKey() + " : ");
			List<String> values = entry.getValue();
			for(String value : values)
			{
				System.out.print(value);
			}
			System.out.println();
		}*/
		
	}

}

