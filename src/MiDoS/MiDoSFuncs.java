package MiDoS;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import main.MainClass;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class MiDoSFuncs {
	static MiDoSLogin MiDoSLogin = new MiDoSLogin();
	public static StringBuilder r = new StringBuilder();
	public static String adjusted;
	ConfigurationBuilder cb = new ConfigurationBuilder();

	TwitterFactory tf = new TwitterFactory(cb.build());
	final Twitter twitter_for_dump = tf.getInstance();

	public static void DumpAyikla() {
		String[] tokens = r.toString().split("\n");
		StringBuilder resultBuilder = new StringBuilder();
		Set<String> alreadyPresent = new HashSet<String>();
		boolean first = true;
		for (String token : tokens) {
			if (!alreadyPresent.contains(token)) {
				if (first)
					first = false;
				else
					resultBuilder.append("\n");
				if (!alreadyPresent.contains(token))
					resultBuilder.append(token);
			}
			alreadyPresent.add(token);
		}
		String results = resultBuilder.toString();
		adjusted = results.replaceAll("(?m)^[ \t]*\r?\n", "");
		MiDoSFuncs.Print(adjusted);
	}

	@SuppressWarnings("static-access")
	public static void TwitAt(String twit) throws IOException {
		try {
			@SuppressWarnings("unused")
			Status status;
			status = MiDoSLogin.twitter().updateStatus(twit);
			MiDoSFuncs.Print(twit + " Paylaşıldı!");
		} catch (TwitterException e) {
			if (e.exceededRateLimitation()) {
				MiDoSFuncs.Print("Hata limit");
			}
			MiDoSFuncs.Print("Hata TwitAt-0x51");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public static String kullaniciAdi() throws IllegalStateException,
			TwitterException, IOException {
		String getkullaniciAdi = MiDoSLogin.twitter().getScreenName();
		return getkullaniciAdi;
	}

	@SuppressWarnings("static-access")
	public static String KD_ratio() throws IllegalStateException,
			TwitterException, IOException {
		User user = MiDoSLogin.twitter().showUser(kullaniciAdi());
		int i_f = user.getFollowersCount();
		int i_fing = user.getFriendsCount();
		double rated = (double) i_f / i_fing;
		DecimalFormat kd_df = new DecimalFormat("#.00");
		String kd = "Takipçi: " + i_f + "\nTakip Ettiği: " + i_fing
				+ "\nKD Ratio: " + kd_df.format(rated) + "\n\n";
		return kd;
	}

	public static void Printx(String log) {
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar
				.getInstance().getTime());

		if (MainClass.gelistirici_modu) {
			System.out.println("[" + timeStamp + "] " + log);
			MiDoSAudio.playx("beep");
		}

		else {
			System.console().writer().println("[" + timeStamp + "] " + log);
			MiDoSAudio.playx("beep");
		}
	}

	public static void Print(String log) {
		if (MainClass.gelistirici_modu) {
			System.out.println(log);
			MiDoSAudio.playx("beep");
		}

		else {
			System.console().writer().println(log);
			MiDoSAudio.playx("beep");
		}
	}

}
