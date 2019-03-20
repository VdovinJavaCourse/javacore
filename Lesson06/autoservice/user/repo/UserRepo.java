package autoservice.user.repo;

import autoservice.common.business.repo.BaseRepo;
import autoservice.user.domain.User;
import autoservice.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo {

    void add(User user);

    User findById(long id);

    List<User> search(UserSearchCondition searchCondition);

}
