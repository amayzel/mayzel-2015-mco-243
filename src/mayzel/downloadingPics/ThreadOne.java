package mayzel.downloadingPics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ThreadOne extends Thread {

	private String aurl;
	private String num;
	public ThreadOne(String aurl, String num) {
		this.aurl = aurl;
		this.num = num;
	}

	@Override
	public void run() {
		try {
			URL url = new URL(aurl);
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			OutputStream os = new FileOutputStream("./imagedownload" +num+".png");
			
			byte[] b = new byte[2048];
	        int length;

	        while ((length = is.read(b)) != -1) {
	            os.write(b, 0, length);
	        }
	        
	        is.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
