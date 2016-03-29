package cn.fan.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.junit.Test;

public class TestConnection {

	@Test
	public void test() throws IOException {
		
		Scanner cin = new Scanner(System.in);
		while(true)
		{	
			String urlstr = cin.nextLine();
			URL url = new URL(urlstr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty( "Content-Type ","application/x-www-form-urlencoded");
			connection.connect();	
			InputStream in = connection.getInputStream();
			
			byte buf[] = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = -1;
			while(( len = in.read(buf)) != -1)
			{
				bos.write(buf, 0, len);
			}
			buf = bos.toByteArray();
			System.out.println(new String(buf, "UTF-8"));
		}
		
	}

}
