package mystore.services;

import java.util.Arrays;
import mystore.entities.User;

public class UserManagementService {

  private User[] users;
  public static UserManagementService instance;
  private int lastIndex = 0;
  private final int DEFAULT_USER_CAPACITY = 10;

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
    if (lastIndex >= users.length) {
      users = Arrays.copyOf(users, users.length << 1);
    }
    users[lastIndex++] = user;
  }

  public User[] getUsers() {
    return users;
  }
}
