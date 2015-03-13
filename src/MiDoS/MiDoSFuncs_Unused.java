package MiDoS;
/*
import java.io.IOException;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
*/
public class MiDoSFuncs_Unused {
/*
 * public static void DumpAyikla(){
	 String[] tokens = r.toString().split("\n");
	 StringBuilder resultBuilder = new StringBuilder();
	 Set<String> alreadyPresent = new HashSet<String>();
	 boolean first = true;
	 for(String token : tokens) {
	     if(!alreadyPresent.contains(token)) {
	         if(first) first = false;
	         else resultBuilder.append("\n");
	         if(!alreadyPresent.contains(token))
	             resultBuilder.append(token);
	     }
	     alreadyPresent.add(token);
	 }
	 String results = resultBuilder.toString();
	 adjusted = results.replaceAll("(?m)^[ \t]*\r?\n", "");
	 MiDoSFuncs.Print(adjusted);
 }
 */
	
 /*
  * public static void TwitAra(String arakey) throws IOException{
 Query query = new Query(arakey);
 QueryResult result = null;
	try {
		result = MiDoSLogin.twitter().search(query);
	} catch (TwitterException e) {
		MiDoSFuncs.Print("Hata TwitAra-0x53");
		e.printStackTrace();
	}
 for (Status status : result.getTweets()) {
	 MiDoSFuncs.Print("@" + status.getUser().getScreenName() + ":" + status.getText());
 }		
}

  */
}
