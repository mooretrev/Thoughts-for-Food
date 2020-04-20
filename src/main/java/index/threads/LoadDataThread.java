package index.threads;

import containers.Data;

public class LoadDataThread extends Thread{
	
	private Data data;
	
	public LoadDataThread() {
		data = new Data();
	}
	
	@Override
	public void run() {
		super.run();
		data.load();
	}
	
	public Data getData() {
		return data;
	}

}
