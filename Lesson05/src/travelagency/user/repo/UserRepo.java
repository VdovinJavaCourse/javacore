package travelagency.user.repo;

import travelagency.common.business.repo.BaseRepo;
import travelagency.user.domain.User;
import travelagency.user.search.UserSearchCondition;

public interface UserRepo extends BaseRepo {
    void add(User country);

    User findById(long id);

    User[] search(UserSearchCondition searchCondition);
}
