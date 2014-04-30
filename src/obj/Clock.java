package obj;

import classes.Main;

public class Clock implements Runnable {
	private int			tickTime;
	
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
	}
	
}
