package obj;

import classes.Main;
import classes.Signal;

public class Clock implements Runnable {
	private int			tickTime;
	private Signal		signal;
	
	public Clock(int tickTime) {
		this.tickTime = tickTime;
	}
	
	@Override
	public void run() {
		while (Main.isRunning()) {
			tick();
		}
	}

	private void tick() {
		try {
			wait(tickTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signal.toggle();
	}
}
