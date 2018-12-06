import java.util.Comparator;
public class UserInfo 
{
	String username;
	int score;
  public UserInfo(String username, int score)
  {
	 this.username = username;
	 this.score = score;
  }
  
  public String getName()
  {
	  return this.username;
	 
  }
  public int getScore()
  {
	  return this.score;
  }
 
}
class NumberComparator implements Comparator<UserInfo>  {
 	public int compare(UserInfo user1, UserInfo user2) {

		if (user1.getScore() < user2.getScore())  //Sorting number in natural way
		  return 1;

		 if (user1.getScore() > user2.getScore())
		  return -1;

 		return 0;
 	}
}