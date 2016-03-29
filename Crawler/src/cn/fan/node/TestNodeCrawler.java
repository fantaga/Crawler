package cn.fan.node;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestNodeCrawler {

	@Test
	public void test() throws IOException {
		
		String linkTag_regex = "<a.*href=\".*\".*>.*</a>";
		
		Pattern p = Pattern.compile(linkTag_regex, Pattern.CASE_INSENSITIVE);
		
		Scanner cin = new Scanner(System.in);
		while(true)
		{	
			
			String urladdr = cin.nextLine();
			URL url = new URL(urladdr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			InputStream instream = connection.getInputStream();
			
			BufferedReader bufr = new BufferedReader(new InputStreamReader(instream));
			
			String line = null;
			while((line = bufr.readLine()) != null)
			{
				Matcher matcher = p.matcher(line);
				
				while(matcher.find())
				{
					System.out.println(matcher.group());
				}
			}
			
		}
	}
	@Test
	public void test02() throws IOException{
		
		String ImageTag_regex = "<img.*src=\".*\".*/>";
		
		Pattern p = Pattern.compile(ImageTag_regex, Pattern.CASE_INSENSITIVE);
		
		Scanner cin = new Scanner(System.in);
		while(true)
		{	
			
			String urladdr = cin.nextLine();
			URL url = new URL(urladdr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			InputStream instream = connection.getInputStream();
			
			BufferedReader bufr = new BufferedReader(new InputStreamReader(instream));
			
			String line = null;
			while((line = bufr.readLine()) != null)
			{
				Matcher matcher = p.matcher(line);
				
				while(matcher.find())
				{
					System.out.println(matcher.group());
				}
			}
			
		}
	}
}
