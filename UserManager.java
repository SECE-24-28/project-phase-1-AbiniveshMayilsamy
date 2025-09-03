import java.util.*;
import java.io.*;
public class UserManager {
 private List<User> users = new ArrayList<>();
 private final String txtFile = "users.txt";
 public UserManager() throws IOException {
        loadUsers();
    }
 public void loadUsers() throws IOException {
        File file = new File(txtFile);
        if (!file.exists()) file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(txtFile));
        String line;
        while ((line = br.readLine()) != null) {
             users.add(User.fromString(line));
        }
        br.close();
 }
  public void saveUser(User user) throws IOException {
        users.add(user);
        BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile));
        bw.write(user.toString());
        bw.newLine();
        bw.close();
     }
    public List<User> getUsers() {
        return users;
 }
}
