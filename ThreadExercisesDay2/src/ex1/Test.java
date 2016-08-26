package ex1;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

		int sum1=0,sum2=0,sum3=0;
		
		String url1, url2, url3;
		
		url1 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
		url2 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png";
		url3 = "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png";
		
		Fiber thread1 = new Fiber(url1);
		Fiber thread2 = new Fiber(url2);
		Fiber thread3 = new Fiber(url3);
		
		long start = System.nanoTime();
		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
		sum1=thread1.getSum();
		sum2=thread2.getSum();
		sum3=thread3.getSum();
		long end = System.nanoTime();
		System.out.println("Time multithread: "+(end-start));
		
//		long start = System.nanoTime();
//		thread1.run();
//		sum1=thread1.getSum();
//		thread2.run();
//		sum2=thread2.getSum();
//		thread3.run();
//		sum3=thread3.getSum();
//		long end = System.nanoTime();
//		System.out.println("Time Sequental: "+(end-start));

		
		System.out.println(sum1+sum2+sum3);
		
		
		
		
	}

}

