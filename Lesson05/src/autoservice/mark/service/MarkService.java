package autoservice.mark.service;

import autoservice.common.business.service.BaseService;
import autoservice.mark.domain.Mark;
import autoservice.mark.search.MarkSearchCondition;

public interface MarkService extends BaseService {

    void add(Mark mark);

    Mark findById(Long id);

    void delete(Mark mark);

    Mark[] search(MarkSearchCondition searchCondition);
}
