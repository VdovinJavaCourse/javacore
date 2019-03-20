package autoservice.mark.repo;

import autoservice.common.business.repo.BaseRepo;
import autoservice.mark.domain.Mark;
import autoservice.mark.search.MarkSearchCondition;

import java.util.List;

public interface MarkRepo extends BaseRepo {

    Mark findById(long id);

    void add(Mark mark);

    List<Mark> search(MarkSearchCondition searchCondition);
}
