package classes;
	
/**
 * 
 * @author mlekena, JP, Nickels Cleves
 * 
 * @use Clock class must simple change the current value of of EventState every specified time interval by calling the Toggle() method. Objects should wait on the same EventState. For instance 
 * factories should all wait for a tick. Then using the clock, it will toggle Tick, factories produce, clock toggles again to Tock, and factories just wait.
 *
 */
public class Signal {
	
	public enum EventState{TICK,TOCK};
	
	protected EventState value;
	
	public Signal( EventState val)
	{
		value = val;
	}
	
	public Signal()
	{
		value = EventState.TOCK;
	}
	
	public void await(EventState ev)
	{
		while (value != ev){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		toggle();
	}
	
	public void set()
	{
		value = EventState.TICK;
		notifyAll();
	}
	
	public void reset()
	{
		value = EventState.TOCK;
		notifyAll();
	}

	public void toggle()
	{
		if (value == EventState.TICK)
		{
			value = EventState.TOCK;
			notifyAll();
		}
		else
		{
			value = EventState.TICK;
			notifyAll();
		}
	}
}
