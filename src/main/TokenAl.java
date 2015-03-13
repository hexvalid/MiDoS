package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import MiDoS.MiDoSFuncs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TokenAl {

	public static void TokenGen() throws TwitterException, IOException {
		// TODO Auto-generated method stub
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("61VQuDDwWfeOZcdhUVIGjexPh",
				"KBLhVUmEDkekCpHX5nQGKuBoblKL4ndtN6ltLhxVVD3BV15rH9");
		RequestToken requestToken = twitter.getOAuthRequestToken();
		AccessToken accessToken = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (null == accessToken) {
			MiDoSFuncs.Print(requestToken.getAuthorizationURL());
			UIVals.openWebpage(requestToken.getAuthorizationURL());
			MiDoSFuncs.Print("PIN kodunu giriniz: ");
			String pin = br.readLine();
			try {
				if (pin.length() > 0) {
					accessToken = twitter
							.getOAuthAccessToken(requestToken, pin);
				} else {
					accessToken = twitter.getOAuthAccessToken();
				}
			} catch (TwitterException te) {
				if (401 == te.getStatusCode()) {
					MiDoSFuncs.Print("Token alınamadı!");
				} else {
					te.printStackTrace();
				}
			}
		}
		MDRFileSystem.yaz(accessToken.getToken(), accessToken.getTokenSecret());
		MiDoSFuncs.Print("Token alındı ve CFG yazıldı!");
		MiDoSFuncs.Print("MiDoS'tan çıkılabilir.");
	}
}
