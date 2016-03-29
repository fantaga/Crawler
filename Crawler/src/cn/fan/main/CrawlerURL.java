package cn.fan.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 
 * @function : 重制定URL中抓取连接
 */
public class CrawlerURL {
	
	public static final String regex_all = 
			"(https?:)?//([\\w]+\\.)+[\\w]+(/[\\w%?#&=+-\\.]*)*";
	
	public static final String regex_imgs =
			//"(https?:)?//(\\w+\\.)+[\\w]+(/[\\w%?#&=+-\\.]+)+\\.(jpg|gif|png)";
			"(https?:)?//([\\w]+\\.)+[\\w]+(/[\\w-]+)+[\\w-\\.]+\\.(jpg|gif|png)";
			
	public static Pattern p1 = Pattern.compile(regex_all);
	public static Pattern p2 = Pattern.compile(regex_imgs);
	
	
	public static final int TYPE_ALL = 1;
	public static final int TYPE_IMGS = 2;
	
	public static HashSet<String>fetchURLs(String URLStr, int type) {
				
				HashSet<String> urls = null;
				
				Pattern p = null;
				if(type == TYPE_ALL)
					p = p1;
				else if(type == TYPE_IMGS)
					p = p2;
				try {
					
					URL Url = new URL(URLStr);
					urls = new HashSet<String>();
					HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
					conn.setConnectTimeout(3000);
					conn.connect();
					
					InputStream instream = conn.getInputStream();
					
					BufferedReader bufr = new BufferedReader(
											new InputStreamReader(instream));
					String line = null;
					while((line = bufr.readLine()) != null)
					{	
						Matcher matcher = p.matcher(line);
						while(matcher.find())
						{
							urls.add(matcher.group());
						}
					}
					
					bufr.close();
					
				}catch (MalformedURLException e) {
					System.err.println("URL格式错误！");
				}catch (IOException e) {
					System.err.println("连接超时！");
				}
				
				return urls;
				
			}
	public static HashSet<String> fetchURLs(File localFile, int type)
	{	
		HashSet<String> urls = null;
		Pattern p = null;
		if(type == TYPE_ALL)
			p = p1;
		else if(type == TYPE_IMGS)
			p = p2;
		
		try {
			BufferedReader bufr = new BufferedReader(
									new InputStreamReader(
										new FileInputStream(localFile)));
			urls = new HashSet<String>();
			String line = null;
			
			while((line = bufr.readLine() )!= null)
			{
				Matcher matcher = p.matcher(line);
				while(matcher.find())
				{
					urls.add(matcher.group());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("找不到指定文件");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return urls;
	}
}
