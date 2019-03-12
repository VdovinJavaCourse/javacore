package autoservice.model.repo;

import autoservice.common.business.repo.BaseRepo;
import autoservice.model.domain.Model;
import autoservice.model.search.ModelSearchCondition;

public interface ModelRepo extends BaseRepo {

    void add(Model model);

    Model findById(long id);

    Model[] search(ModelSearchCondition searchCondition);
}
