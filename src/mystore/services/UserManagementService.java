package mystore.services;

import java.util.Arrays;
import mystore.entities.User;

public class UserManagementService {

  private User[] users;
  private static UserManagementService instance;
  private int lastIndex = 0;
  private final int DEFAULT_USER_CAPACITY = 10;
  private String NO_ERROR_MSG = "";
  private String NOT_UNIQUE_EMAIL =
    "The email is already registerd user another";
  private String EMPTY_EMAIL = "Email can't be empty";

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

  public String checkEmail(String email) {
    if (email.isEmpty()) {
      return EMPTY_EMAIL;
    }
    for (User user : users) {
      if (user != null && email.equals(user.getEmail())) {
        return NOT_UNIQUE_EMAIL;
      }
    }
    return NO_ERROR_MSG;
  }

  public User validateUser(String email, String password) {
    for (User user : users) {
      if (
        user.getEmail().equals(email) && user.getPassword().equals(password)
      ) {
        return user;
      }
    }
    return null;
  }

  public User[] getUsers() {
    if (lastIndex == 0) {
      return new User[0];
    }
    return users;
  }
}
