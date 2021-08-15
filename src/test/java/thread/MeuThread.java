package thread;

public class MeuThread implements Runnable{

	public void run(){
		try {
			Thread.sleep(100);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
