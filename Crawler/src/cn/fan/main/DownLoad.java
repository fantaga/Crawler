package cn.fan.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;

public class DownLoad {
	
	private HashSet<String> urls;
	
	private URL url;

	public DownLoad(HashSet<String> urls) {
		
		this.urls = urls;
	}

	public DownLoad(URL url) {

		this.url = url;
	}
	
	public DownLoad() {

	}

	public int downLaod() {
		// TODO Auto-generated method stub
		InputStream instream = null;
		FileOutputStream fout = null;
		try {
			instream = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		
		try {
			fout = new FileOutputStream(
										new File(System.currentTimeMillis()+ ""));
			byte buf[] = new byte[1024 * 2];
			
			int len = -1;
			
			while((len = instream.read(buf)) != -1)
			{
				fout.write(buf, 0, len);
			}
			instream.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public int downLaod(String url) {
		// TODO Auto-generated method stub
		InputStream instream = null;
		FileOutputStream fout = null;
		
		String fileType = url.substring(url.lastIndexOf("."), url.length());
		try {
			instream = new URL(url).openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		
		try {
			fout = new FileOutputStream(
										new File("D:\\Picture\\" + System.currentTimeMillis() + fileType));
			byte buf[] = new byte[1024 * 2];
			
			int len = -1;
			
			while((len = instream.read(buf)) != -1)
			{
				fout.write(buf, 0, len);
			}
			instream.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public void downLoadAll() {
		
		for (String url : urls) 
		{
			this.downLaod(url);
		}
	}
}
	
	
