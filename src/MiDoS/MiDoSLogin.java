package MiDoS;

import java.io.IOException;

import main.MDRFileSystem;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MiDoSLogin {

	public final static Twitter twitter() throws IOException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("61VQuDDwWfeOZcdhUVIGjexPh")
				.setOAuthConsumerSecret(
						"KBLhVUmEDkekCpHX5nQGKuBoblKL4ndtN6ltLhxVVD3BV15rH9")
				//
				.setOAuthAccessToken(MDRFileSystem.oku1())
				.setOAuthAccessTokenSecret(MDRFileSystem.oku2());
		TwitterFactory tf = new TwitterFactory(cb.build());
		final Twitter twitter = tf.getInstance();
		MiDoSFuncs.Print("[M] MiDoSLogin dump edildi.");
		return twitter;
	}

}