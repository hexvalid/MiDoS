package MiDoS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import twitter4j.IDs;
import twitter4j.TwitterException;

public class MiDoSDeleteBot {
	@SuppressWarnings("unused")
	public static void StartDelete() {
		IDs ids = null;
		IDs friends = null;
		try {
			ids = MiDoSLogin.twitter().getFriendsIDs(-1);

			Map<Long, Long> friendsList = new HashMap<Long, Long>();

			for (long id : ids.getIDs()) {
				{
					MiDoSLogin.twitter().destroyFriendship(id);
					MiDoSFuncs.Print(id + " [OK] Unfollow işlemi sürüyor...");
				}
			}

		} catch (TwitterException | IOException e) {
			e.printStackTrace();
			MiDoSFuncs
					.Print("\n[FATAL ERR] Unfollow işlemi kesildi! \n Daha sonra tekrar deneyiniz!");
		}
	}
}
