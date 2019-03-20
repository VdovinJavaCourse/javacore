package travelagency.user.repo.impl;

import travelagency.user.domain.User;
import travelagency.user.repo.UserRepo;
import travelagency.user.search.UserSearchCondition;

import java.util.Collections;
import java.util.List;

import static travelagency.storage.Storage.usersList;

public class UserMemoryCollectionRepo implements UserRepo {

    @Override
    public void add(User user) {
        usersList.add(user);
    }

    @Override
    public User findById(long id) {
        return findUserById(id);
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
        User found = findUserById(id);

        if (found != null) {
            usersList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (User user : usersList) {
            System.out.println(user);
        }
    }

    private User findUserById(long id) {
        for (User user : usersList) {
            if (Long.valueOf(id).equals(user.getId())) {
                return user;
            }
        }
        return null;
    }
}
