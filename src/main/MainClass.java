package main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import twitter4j.TwitterException;
import MiDoS.MiDoSAudio;
import MiDoS.MiDoSDeleteBot;
import MiDoS.MiDoSFollowTagsDumpBot;
import MiDoS.MiDoSFuncs;
import MiDoS.MiDoSUnfollowBot;

public class MainClass {
	// /////////////////INIT VALUES//////////////////////////
	public static String version = "2.0 ";
	public static boolean gelistirici_modu = false;
	// /////////////////INIT VALUES//////////////////////////
	static int menu_a;
	static String menu_a_boolean_S;
	static boolean menu_a_boolean;

	static int menu_a_1;
	public static int menu_a_2;

	public static void main(String[] args) throws IOException {
		MiDoSFuncs.Print("MiDoS'a Hoşgeldin!\nVersiyon: " + version + "\n"
				+ UIVals.legal + "\n");
		int n1 = new Random().nextInt(2) + 1;
		MiDoSAudio.playx("welcome" + n1);
		AnaMenu();
	}

	public static void AnaMenu() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		MiDoSFuncs.Print(UIVals.anamenu);
		MiDoSFuncs.Print("Seçim:");
		menu_a = reader.nextInt();
		if (menu_a == 1) {

			MiDoSFuncs.Print("Twit Atılsın mı? (E/h): ");

			menu_a_boolean_S = reader.next();
			if (menu_a_boolean_S.equals("E") || menu_a_boolean_S.equals("e"))
				menu_a_boolean = true;
			else
				menu_a_boolean = false;
			MiDoSFuncs.Print("Zamanaşımı: ");
			menu_a_1 = reader.nextInt();
			MiDoSFuncs.Print("Loop bekleme süresi: ");
			menu_a_2 = reader.nextInt();
			try {
				MiDoSFuncs.Print(MiDoSFuncs.kullaniciAdi()
						+ " ile giriş yapıldı!\n" + MiDoSFuncs.KD_ratio());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (TwitterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			MiDoSFollowTagsDumpBot.StartBot(menu_a_boolean, menu_a_1, menu_a_2);

		} else if (menu_a == 2) {
			MiDoSUnfollowBot.StartBot();
		} else if (menu_a == 3) {
			MiDoSDeleteBot.StartDelete();
		} else if (menu_a == 9) {
			try {
				TokenAl.TokenGen();
			} catch (TwitterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// Gökşah Voice Transmitter:
	// public static void LED(String renk) throws IOException {
	// Runtime.getRuntime().exec(new String[]{"/bin/sh" ,"-c",
	// "echo -n -e '"+renk+"' > /dev/ttyACM0"});
	// }

}
