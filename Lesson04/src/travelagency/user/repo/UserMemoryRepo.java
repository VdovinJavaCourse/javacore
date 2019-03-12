package travelagency.user.repo;

import travelagency.common.ArrayUtils;
import travelagency.user.User;

import static travelagency.storage.Storage.users;

public class UserMemoryRepo {

    private int userIndex = -1;

    public void add(User user) {
        if (userIndex == users.length-1) {
            User[] newArrUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newArrUsers, 0, users.length);
            users = newArrUsers;
        }
        userIndex++;
        users[userIndex] = user;
    }

    public User findUserById(long id) {
        Integer foundIndex = findUserIndexById(id);

        if (foundIndex != null) {
            return users[foundIndex];
        }
        return null;
    }

    private Integer findUserIndexById(Long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public void deleteUser(User user) {
        Integer foundIndex = findUserIndexByEntity(user);

        if (foundIndex != null) {
            deleteUserByIndex(foundIndex);
        }
    }

    private Integer findUserIndexByEntity(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                return i;
            }
        }
        return null;
    }

    private void deleteUserByIndex(int index) {
        ArrayUtils.removeElement(users, index);
        userIndex--;
    }

    public void deleteUser(Long id) {
        Integer foundIndex = findUserIndexById(id);

        if (foundIndex != null) {
            deleteUserByIndex(foundIndex);
        }
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

