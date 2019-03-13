package autoservice.mark.service.impl;

import autoservice.mark.domain.Mark;
import autoservice.mark.repo.MarkRepo;
import autoservice.mark.search.MarkSearchCondition;
import autoservice.mark.service.MarkService;
import autoservice.model.domain.Model;
import autoservice.model.repo.ModelRepo;

public class MarkDefaultService implements MarkService {

    private final MarkRepo markRepo;
    private final ModelRepo modelRepo;

    public MarkDefaultService(MarkRepo markRepo, ModelRepo modelRepo) {
        this.markRepo = markRepo;
        this.modelRepo = modelRepo;
    }

    public void add(Mark mark) {
        if (mark != null) {
            markRepo.add(mark);


            if (mark.getModels() != null) {
                for (Model model : mark.getModels()) {
                    if (model != null) {
                        modelRepo.add(model);
                    }
                }
            }
        }
    }

    public Mark findById(Long id) {
        if (id != null) {
            return markRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Mark[] search(MarkSearchCondition searchCondition) {
        return markRepo.search(searchCondition);
    }

    public void delete(Mark mark) {
        if (mark.getId() != null) {
            this.deleteById(mark.getId());
        }
    }

    public void deleteById(Long id) {
        if (id != null) {
            markRepo.deleteById(id);
        }
    }

    public void printAll() {
        markRepo.printAll();
    }
}
