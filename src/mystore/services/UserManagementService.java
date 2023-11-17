package mystore.services;

import java.util.Arrays;
import mystore.entities.User;

public class UserManagementService {

  private User[] users;
  private static final int DEFAULT_USER_CAPACITY = 20;
  private static final String EMPTY_EMAIL = "You have to enter email";
  private static final String SAME_EMAIL = "Already present email";
  private static UserManagementService instance;
  private int lastIdx = 0;

  {
    users = new User[DEFAULT_USER_CAPACITY];
  }

  public static UserManagementService getInstance() {
    if (instance == null) {
      instance = new UserManagementService();
    }
    return instance;
  }

  public void addUser(User user) {
    if (lastIdx >= users.length) {
      users = Arrays.copyOf(users, users.length << 1);
    }
    users[lastIdx++] = user;
  }

  public String chekcEmail(String email) {
    if (email == null || email.isEmpty()) {
      return EMPTY_EMAIL;
    }
    for (User user : users) {
      if (user != null && user.getEmail().equals(email)) {
        return SAME_EMAIL;
      }
    }
    return "";
  }

  public User[] getUsers() {
    return users;
  }

  public User getUser(String email, String password) {
    for (User user : users) {
      if (
        user != null &&
        user.getEmail().equals(email) &&
        user.getPassword().equals(password)
      ) {
        return user;
      }
    }
    return null;
  }
}
