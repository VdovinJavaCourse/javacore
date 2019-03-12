package autoservice.mark.repo;

import autoservice.common.business.repo.BaseRepo;
import autoservice.mark.domain.Mark;
import autoservice.mark.search.MarkSearchCondition;

public interface MarkRepo extends BaseRepo {

    Mark findById(long id);

    void add(Mark mark);

    Mark[] search(MarkSearchCondition searchCondition);
}
