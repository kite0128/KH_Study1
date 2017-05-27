package java0808_network;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Java215_url {

	public static void main(String[] args) {
			try {
				URL url = new URL("http://www.naver.com:80");
				System.out.printf("getHost():%s\n",url.getHost());
				System.out.printf("getPort():%s\n",url.getPort());
				System.out.printf("getProtocal():%s\n",url.getProtocol());
				System.out.printf("getPath():%s\n",url.getPath());
				System.out.printf("getURI():%s\n",url.toURI());
				
			} catch (MalformedURLException e) {
			
				e.printStackTrace();
			} catch (URISyntaxException e) {
				
				e.printStackTrace();
			}
	}

}
