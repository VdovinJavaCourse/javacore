package autoservice.user.service.impl;

import autoservice.user.domain.User;
import autoservice.user.repo.UserRepo;
import autoservice.user.service.UserService;

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

    public void deleteById(Long id) {
        if (id != null) {
            userRepo.deleteById(id);
        }
    }

    public void printAll() {
        userRepo.printAll();
    }


}
