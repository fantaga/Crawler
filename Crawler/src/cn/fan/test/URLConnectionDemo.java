package cn.fan.test;
import java.net.*;
import java.io.*;
class  URLConnectionDemo
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("http://www.baidu.com");

		URLConnection conn = url.openConnection();
		System.out.println(conn);
		
		InputStream in = conn.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(new String(buf,0,len));






	}
}
