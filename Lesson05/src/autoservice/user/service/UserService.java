package autoservice.user.service;

import autoservice.common.business.service.BaseService;
import autoservice.user.domain.User;

public interface UserService extends BaseService {

    void add(User user);

    User findById(Long id);

    void delete(User user);
}
