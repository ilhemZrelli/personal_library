package threads;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SessionThread implements Runnable {
	private boolean isRunning;
	
	private JFrame frame;
	private JTextField text;
	public SessionThread(JTextField text) {
	this.isRunning=false;
	this.text=text;
	}
	@Override
	public void run() {
		int i=Integer.parseInt(text.getText());
		isRunning = true;
		while(isRunning)
		{  
			
			try {
				//this.text.setText(this.text.getText());
				this.text.setText(String.valueOf(i));
				if(i>0) {
				
				Thread.sleep(60000);
				
				 i--;
				}
				else {
					this.stop();
					System.out.println("compteur fini");
				}
				 System.out.println(i);
			}catch(InterruptedException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	public void stop() {
		this.isRunning=false;
		
	}

}
