package main;

import java.awt.Desktop;
import java.net.URL;

public class UIVals {

	public static String anamenu = "Seçiniz:\n" + "1: MiDoSFollowTagsDumpBot\n"
			+ "2: MiDoSUnfollowBot\n" + "3: MiDoSDeleteBot\n" + "9: Token Al\n";

	public static String legal = "";

	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
