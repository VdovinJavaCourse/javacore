package autoservice.mark.service;

import autoservice.common.business.service.BaseService;
import autoservice.mark.domain.Mark;
import autoservice.mark.search.MarkSearchCondition;

import java.util.List;

public interface MarkService extends BaseService {

    void add(Mark mark);

    Mark findById(Long id);

    void delete(Mark mark);

    List<Mark> search(MarkSearchCondition searchCondition);
}
