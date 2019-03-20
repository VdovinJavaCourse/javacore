package autoservice.user.service;

import autoservice.common.business.service.BaseService;
import autoservice.user.domain.User;
import autoservice.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void add(User user);

    User findById(Long id);

    void delete(User user);

    List<User> search(UserSearchCondition searchCondition);
}
