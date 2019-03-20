package travelagency.user.service.impl;

import travelagency.user.domain.User;
import travelagency.user.repo.UserRepo;
import travelagency.user.search.UserSearchCondition;
import travelagency.user.service.UserService;

import java.util.Collections;
import java.util.List;


public class UserDefaultService implements UserService {

    private final UserRepo userRepo;

    public UserDefaultService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void add(User user) {
        if (user != null) {
            userRepo.add(user);
        }
    }

    public User findById(Long id) {
        if (id != null) {
            return userRepo.findById(id);
        } else {
            return null;
        }
    }

    public void delete(User user) {
        if(user.getId()!=null){
            this.deleteById(user.getId());
        }
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    public void deleteById(Long id) {
        if (id != null) {
            userRepo.deleteById(id);
        }
    }

    public void printAll() {
        userRepo.printAll();
    }
}