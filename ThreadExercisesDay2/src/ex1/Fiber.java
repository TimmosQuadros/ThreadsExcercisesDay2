package ex1;

import java.io.IOException;

public class Fiber extends Thread {

	private String url;
	private byte[] image;
	private int sum;

	public int getSum() {
		return sum;
	}

	public byte[] getImage() {
		return image;
	}

	public Fiber(String url) {
		this.url = url;
	}

	//	@Override
	//	public void run() {
	//		super.run();
	//		try {
	//			this.image=Imagereader.getBytesFromUrl(url);
	//			sum=sumOfByteArray(image);
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//	}

	@Override
	public void run() {
		try {
			this.image=Imagereader.getBytesFromUrl(url);
			sum=sumOfByteArray(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	public int sumOfByteArray(byte[] image){
		int sum = 0;
		for (byte b : image) {
			sum+=b;
		}
		return sum;
	}

}
