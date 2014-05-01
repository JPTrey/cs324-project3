package classes;

public class Text {
	public static void debug(String debugText) {
		if (Main.debug) {
			System.out.println(debugText);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
