package ex2;


import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread{
	private long tal;
	private long result;

	List<FibonacciObserver> observers = new ArrayList<>();

	public void registerFibonacciObserver(FibonacciObserver o){
		System.out.println(o.toString());
		observers.add(o);
	}

	public void unregisterFibonacciObserver(FibonacciObserver o){
		observers.remove(o);
	}

	public FibonacciTask() {
	}


	@Override
	public void run() {
		//		if(tal<=2){
		//			result = 1;
		//		}else{
		//			try{
		//				FibonacciTask f1 = new FibonacciTask(tal-1);
		//				FibonacciTask f2 = new FibonacciTask(tal-2);
		//				f1.start();
		//				f2.start();
		//				f1.join();
		//				f2.join();
		//				result = f1.result+f2.result;
		//			}catch(InterruptedException ex){
		//				ex.printStackTrace();
		//			}
		//		}
		setResult(fib(tal));
	}

	public void notifyAllObservers(){
		for(FibonacciObserver observer : observers){
			observer.dataReady(result);
		}
	} 

	public void setResult(long result) {
		this.result = result;
		notifyAllObservers();
	}

	public long getResult() {
		return result;
	}


	public void setTal(long tal){
		this.tal = tal;
	}

	private long fib(long n) {
		if ((n == 0) || (n == 1)) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}



}
