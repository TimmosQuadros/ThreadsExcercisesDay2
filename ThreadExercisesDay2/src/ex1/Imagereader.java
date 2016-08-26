package ex1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Imagereader {
	
	

	public static byte[] getBytesFromUrl(String url) throws IOException {
		URLConnection connection = new URL(url).openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		connection.connect();
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		//final ReentrantLock lock = new ReentrantLock();
		try {
		//	lock.lock();
			InputStream is = connection.getInputStream();
			byte[] bytebuff = new byte[4096];
			int read;
			while ((read = is.read(bytebuff)) > 0) {
				bis.write(bytebuff, 0, read);
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}finally {
			//lock.unlock();
		}
		return bis.toByteArray();
	}
//Test##########
//	public static void main(String[] args) throws IOException {
//		byte[] image;
//		String url1 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
//		image=getBytesFromUrl(url1);
//		int sum=0;
//		
//		for (byte b : image) {
//
//			System.out.println(b);
//		}
//		System.out.println(sum);
//	}


}
