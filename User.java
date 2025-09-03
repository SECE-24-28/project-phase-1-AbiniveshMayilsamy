public class User {
    private String userID;
    private String name;
    private String email;
    public User(String userID, String name, String email) {
        this.userID = userID;
         this.name = name;
          this.email = email;
    } 
     public String getUserID() {
        return userID;
    } 
     public String getName() {
        return name;
    } 
     public String getEmail() {
        return email;
    }
     public String toString() {
        return userID + "," + name + "," + email;
    }
      public static User fromString(String line) {
        String[] parts = line.split(",");
        return new User(parts[0], parts[1], parts[2]);
    }
}
