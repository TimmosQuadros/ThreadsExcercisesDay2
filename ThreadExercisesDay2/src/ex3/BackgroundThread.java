package ex3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BackgroundThread extends Thread {

	private Filewriter filewriter;
	List<String> data = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();

	public BackgroundThread() {
		filewriter = new Filewriter();
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> lines) {
		this.data = lines;
	}

	public void registerObserver(Observer o){
		observers.add(o);
	}

	public void notifyAllObservers(){
		for(Observer observer : observers){
			observer.updateArray();
		}
	} 

	public String listToString(){
		String s="";
		for (String line : data) {
			s+=line+"\n";
		}
		return s;
	}

	@Override
	public synchronized void start() {
		super.start();
	}
	@Override
	public void run() {
		super.run();
		while(true){
			try {
				filewriter.write(listToString());
				Thread.sleep(15000);
				notifyAllObservers();
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}	
		}

	}


}
