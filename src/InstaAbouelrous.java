//Khalid Abouelrous
//Grade 100/100; program works as intended. output is correct. styling and indentation is correct. comments given throughout code.

import java.util.*;
public class InstaAbouelrous{
}
class User implements Comparable {
   //attributes of a user
   private String first;
   private String last;
   private String username;
   private boolean followBack;
     
   //constructor
   public User(String first, String last, String username, boolean followBack){
       this.first = first;
       this.last = last;
       this.username = username;
       this.followBack = followBack;
   }
   //return whether this person follows another user back
   public boolean getFollow()
   {
      return followBack;
   }
   //unfollowing another user
   public void unfollow()
   {
      followBack = false;
   }
   //following another user
   public void  follow()
   {
      followBack = true;
   }
   //returning first name of user
   public String getFirst() {
      return first;
   }
   //returning last name of user
   public String getLast() {
      return last;
   }
   //getting first name of user
   public void setFirst(String first) {
      this.first = first;
   }
   //getting last name of user
   public void setLast(String last) {
      this.last = last;
   }
   //getting username of user
   public String getUsername()
   {
      return username;
   }
   //compareing this user's username to a username of a provided user
   public int compareTo(Object o) {
      User n = (User)o;
      int compare = this.username.compareTo(n.username);
      return compare;
   }
   //comparing the first and last names of this user to anothe user
   public boolean equals(User other) {
      return this.first.equalsIgnoreCase(other.first) && this.last.equalsIgnoreCase(other.last);
   }
   //returning all the user's information to a string
   public String toString() {
      return "Name: " + first + " " + last +
              "\nUsername: " + username;
   }
}

class SocialMedia{
   //attribute of social media
   private ArrayList<User> app;
   //constructor method
   public SocialMedia(){
      app = new ArrayList<User>();
   }
   //search for a user using first and last name then following that user
   public void followBack(String first, String last) {
      String s = first + " " + last;
      for(int i = 0; i < app.size(); i++){
         String s1 = app.get(i).getFirst() + " " + app.get(i).getLast();
         if(s1.equalsIgnoreCase(s)){
            app.get(i).follow();
         }
      }
   }
   //adding a user to follow
   public boolean follow(String first, String last, String username, boolean followBack) {
      User u = new User(first, last, username, followBack);
      app.add(app.size(), u);
      return true;
   }
   //removing a user from your following list
   public boolean remove(String first, String last ) {
      String s = first + " " + last;
      for(int i = 0; i < app.size(); i++) {
         String s1 = app.get(i).getFirst() + " " + app.get(i).getLast();
         if (s1.equalsIgnoreCase(s)) {
            app.remove(i);
            return true;
         }
      }
      return false; // must change
   }
   //searching for a user
   public boolean search(String first, String last) {
      String s = first + " " + last;
      for(int i = 0; i < app.size(); i++){
         String s1 = app.get(i).getFirst() + " " + app.get(i).getLast();
         if(s1.equalsIgnoreCase(s)){
            return true;
         }
      }
      return false;
   }
   //returning list of following
   public ArrayList<User >getList(){
      return app;
   }
   //returning number of followers
   public int followerCounts() {
      return app.size();
   }
   //returning number of following
   public int followingCounts() {
      int f = 0;
      for(int i = 0; i<app.size(); i++){
         if(app.get(i).getFollow() == true){
            f++;
         }
      }
      return f;
   }
   //turning the social media list into a string
   public String toString() { 
     String s = "";
     for(int i = 0; i<app.size(); i++){
        s = s + "\n\nName: " + app.get(i).getFirst() + " " + app.get(i).getLast() +
                "\nUsername: " + app.get(i).getUsername();
     }
      return s;
   }
}

class MyDriver {
   public static void main(String[] args){
      //creating new scanner and social media
      Scanner temp = new Scanner(System.in);
      SocialMedia khalidInsta = new SocialMedia();

      //following 5 users
      khalidInsta.follow("Salam", "Moe", "salamRoger", true);
      khalidInsta.follow("Amaan", "Sandy", "AmaanSandy", true);
      khalidInsta.follow("Hamie", "Ham", "hamietheham", false);
      khalidInsta.follow("Cristiano", "Ronaldo", "trash", false);
      khalidInsta.follow("Leo", "Messi", "theGoat", true);

      //printing out list of followers
      System.out.println("My followers:");
      System.out.println(khalidInsta);

      //searching for a user using first and last names
      System.out.println("Search for a name person");
      System.out.println("Enter a first name:");
      String first = temp.next();
      System.out.println("Enter a last name:");
      String last = temp.next();
      khalidInsta.search(first, last);

      //removing a person from the social media list
      System.out.println("From the list above please remove a follower.");
      System.out.println("Enter a first name:");
      String first1 = temp.next();
      System.out.println("Enter a last name:");
      String last1 = temp.next();
      khalidInsta.remove(first1, last1);

      //printing out list of followers
      System.out.println("List of followers after removing " + first1 + " " + last1);
      System.out.println(khalidInsta);

      //following back a user
      System.out.println("Enter the first and  last name from the list above that you want to follow back: ");
      String first2 =temp.next();
      String last2 = temp.next();
      khalidInsta.followBack(first2,last2);
      
   }
}

class Driver{
   public static void main(String[]args) {
      SocialMedia myInsta = new SocialMedia();
      
    	/*Adding followers to your list*/
      /*the boolean field indicates whether you want to follow them back*/
      myInsta.follow("Matthew", "Philips", "MatPhil", true);
      myInsta.follow("Gary", "Kane",  "GKane", false); 
      myInsta.follow("Robert", "Kenny",  "RKenny", true); 
      myInsta.follow("Bill", "Fitch", "BillF",true);
      myInsta.follow("Trevor", "Schlulz", "TrevorS", false);
      
    	/*Displaying your followers*/
      System.out.println("Your followers informations\n");
      System.out.println(myInsta);
    	
      /*Unfollowing a user*/
      System.out.println("Removing Robert Kenny from your followers list");
      myInsta.remove("Robert", "Kenny");
   	
      /*Displaying the list*/
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(myInsta);
   	
      /*adding a new follower*/
      System.out.println("Adding Elon Musk to your list of followers");
      myInsta.follow("Elon", "Musk", "ElonM", true);
      
      /*Dipslying the followers*/
      System.out.println("List of your followers:");
      System.out.println(myInsta);
   	
      /*Searching for a follower*/
      System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
      if(myInsta.search("Jackson", "Stonewall") == false) {
         System.out.println("Stonewall Jackson is not in your list of followers");
         System.out.println("\n***************************");   
         System.out.println("You are following " + myInsta.followerCounts() + " people");
      
         System.out.println("You have " + myInsta.followingCounts() + " followers");  
         System.out.println(myInsta);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the first and  last name from the list bellow that you want to follow back: ");
      
         String first =kb.next();
         String last = kb.next();
         myInsta.followBack(first,last);
      
         System.out.println(myInsta);
      
      }
   	
   }
}