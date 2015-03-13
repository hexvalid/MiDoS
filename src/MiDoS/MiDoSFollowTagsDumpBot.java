package MiDoS;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import main.MDRFileSystem;
import main.MainClass;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MiDoSFollowTagsDumpBot {

	public static void StartBot(boolean twitvaryok, int zamanasimi_sn,
			int dongubeklemesi_sn) {
		int x = 0;

		while (x != 1000) {
			x++;
			try {
				MiDoSFuncs.Printx(x + " nolu döngü yürüyor...\n");
				MiDoSAudio.playx("sysstarting");
				if (twitvaryok == true) {
					Random rand = new Random();
					int n = rand.nextInt(500) + 1;
					try {
						MiDoSFuncs.TwitAt(MDRFileSystem.gettwit() + " (" + n
								+ ")");
					} catch (IOException e) {
						e.printStackTrace();
					}
					MiDoSAudio.playx("twitsended");
				}
				DumpAra(MDRFileSystem.gettags(1), zamanasimi_sn);
				DumpAra(MDRFileSystem.gettags(2), zamanasimi_sn);
				DumpAra(MDRFileSystem.gettags(3), zamanasimi_sn);
				DumpAra(MDRFileSystem.gettags(4), zamanasimi_sn);
				DumpAra(MDRFileSystem.gettags(5), zamanasimi_sn);
				DumpAra(MDRFileSystem.gettags(6), zamanasimi_sn);
				try {
					DumpAra(MDRFileSystem.gettags(7), zamanasimi_sn);
				} catch (IOException e) {
					e.printStackTrace();
				}
				MiDoSFuncs.Printx(x + " nolu döngü bitti." + " Diğeri için "
						+ MainClass.menu_a_2 + " saniye bekleniyor...\n");
				MiDoSAudio.playx("syswaiting");
				try {
					Thread.sleep(dongubeklemesi_sn * 1000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();

				}
			} catch (IOException e1) {
				e1.printStackTrace();
				MiDoSFuncs.Printx("Döngü başarısız, dosya okuma hatası!");
			}
		}
	}

	public static void DumpAra(String hashtag, int runtime) {
		try {
			Query query = new Query(hashtag);
			QueryResult result = null;
			boolean skip;
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
					.setOAuthConsumerKey("61VQuDDwWfeOZcdhUVIGjexPh")
					.setOAuthConsumerSecret(
							"KBLhVUmEDkekCpHX5nQGKuBoblKL4ndtN6ltLhxVVD3BV15rH9")
					// set.Auth(response);
					.setOAuthAccessToken(MDRFileSystem.oku1())
					.setOAuthAccessTokenSecret(MDRFileSystem.oku2());
			TwitterFactory tf = new TwitterFactory(cb.build());
			final Twitter twitter_for_dump = tf.getInstance();
			MiDoSFuncs.Printx("[M] MiDoSFollowTagsDumpBot dump edildi.");
			MiDoSAudio.playx("dumped");

			result = twitter_for_dump.search(query);

			for (Status status : result.getTweets()) {
				try {
					if (twitter_for_dump.showFriendship(
							twitter_for_dump.getScreenName(),
							status.getUser().getScreenName())
							.isSourceFollowingTarget()) {
						MiDoSFuncs
								.Printx("[ERR] "
										+ (status.getUser().getScreenName() + " zaten takip ediliyor!"));
						MiDoSAudio.playGoksahError();
						skip = true;
					} else {
						twitter_for_dump.createFriendship(status.getUser()
								.getScreenName());
						MiDoSFuncs
								.Printx("[OK] "
										+ (status.getUser().getScreenName() + " takip edildi."));
						MiDoSAudio.playGoksahOkey();
						skip = false;
					}
				} catch (TwitterException e) {
					skip = true;
					try {
						if (twitter_for_dump.getScreenName().equals(
								status.getUser().getScreenName())) {
							MiDoSFuncs.Printx("[ERR] Kendine takıldın!");
							MiDoSAudio.playx("trappedyourself");

						} else {
							MiDoSFuncs
									.Printx(("[FATAL ERR] "
											+ status.getUser().getScreenName() + " takip edilemedi!"));
							MiDoSAudio.playx("fatalerr01");
						}
					} catch (TwitterException e1) {
						if (e1.exceededRateLimitation()) {
						}
						MiDoSAudio.playx("banned");

						Map<String, RateLimitStatus> rateLimitStatus;
						rateLimitStatus = twitter_for_dump.getRateLimitStatus();
						// for search , endpoint : /search/tweets
						String endpoint = "/search/tweets";
						RateLimitStatus status1 = rateLimitStatus.get(endpoint);
						int parkur = status1.getSecondsUntilReset() + 10;
						MiDoSFuncs.Printx("[L] Twitter Limitine takıldın! "
								+ parkur + " saniye bekleniyor... ");
						MiDoSAudio.playx("syswaiting");

						try {

							Thread.sleep(parkur * 1000);
						} catch (InterruptedException e2) {
							e2.printStackTrace();
						}

					}
				}

				try {
					if (!skip) {
						Thread.sleep(runtime * 1000);
					}
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
					MiDoSFuncs.Printx("safadsf");
				}
			}

		} catch (TwitterException e) {

			e.printStackTrace();
		} catch (IOException e2) {
			MiDoSFuncs.Printx("Hata Read-0x03");
			e2.printStackTrace();
		}
	}
}
