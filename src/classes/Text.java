package classes;

public class Text {
	public static void debug(String debugText) {
		if (Main.debug)
			System.out.println(debugText);
	}
}
