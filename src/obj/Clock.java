package obj;

import classes.Main;
import classes.Signal;

public class Clock implements Runnable {
	private int			tickTime, units;
	private Signal		signal;
	
	public Clock(int tickTime) {
		this.tickTime = tickTime;
		units = 0;
	}
	
	@Override
	public void run() {
		while (Main.isRunning()) {
			tick();
			units++;
			Main.updateTimeUnits(units);
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
