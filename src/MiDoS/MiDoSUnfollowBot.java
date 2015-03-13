package MiDoS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import twitter4j.IDs;
import twitter4j.TwitterException;

public class MiDoSUnfollowBot {
	public static void StartBot() {
		IDs ids = null;
		IDs friends = null;
		try {
			friends = MiDoSLogin.twitter().getFollowersIDs(-1);
			ids = MiDoSLogin.twitter().getFriendsIDs(-1);

			long friendsArray[] = friends.getIDs();

			Map<Long, Long> friendsList = new HashMap<Long, Long>();

			for (long fid : friendsArray) {
				friendsList.put(fid, fid);
			}

			for (long id : ids.getIDs()) {
				if (friendsList.get(id) == null) {
					MiDoSLogin.twitter().destroyFriendship(id);
					MiDoSFuncs.Print("[OK] Unfollow işlemi sürüyor...");
				}
			}

		} catch (TwitterException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MiDoSFuncs
					.Print("\n[FATAL ERR] Unfollow işlemi kesildi! \n Daha sonra tekrar deneyiniz!");
		}
	}
}
