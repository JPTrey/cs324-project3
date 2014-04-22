package classes;

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
