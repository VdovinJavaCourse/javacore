package travelagency.user.service;

import travelagency.common.business.service.BaseService;
import travelagency.user.domain.User;

public interface UserService extends BaseService {

    void add(User user);

    User findById(Long id);

    void delete(User user);
}
