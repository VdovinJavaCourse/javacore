package travelagency.user.repo;

import travelagency.common.business.repo.BaseRepo;
import travelagency.user.domain.User;
import travelagency.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo {
    void add(User country);

    User findById(long id);

    List<User> search(UserSearchCondition searchCondition);
}
