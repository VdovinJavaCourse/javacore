package autoservice.model.service;

import autoservice.common.business.service.BaseService;
import autoservice.model.domain.Model;
import autoservice.model.search.ModelSearchCondition;

public interface ModelService extends BaseService {

    void add(Model model);

    Model findById(Long id);

    void delete(Model model);

    //Model[] search(ModelSearchCondition searchCondition);
}
