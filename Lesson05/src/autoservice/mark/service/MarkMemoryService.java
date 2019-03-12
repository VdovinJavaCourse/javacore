package autoservice.mark.service;

import autoservice.mark.domain.Mark;
import autoservice.mark.repo.impl.MarkMemoryRepo;
import autoservice.model.domain.Model;
import autoservice.model.repo.impl.ModelMemoryRepo;

public class MarkMemoryService {

    private MarkMemoryRepo markRepo = new MarkMemoryRepo();
    private ModelMemoryRepo modelRepo = new ModelMemoryRepo();

    public void addMark(Mark mark) {
        markRepo.addMark(mark);

        if (mark.getModels() != null) {
            for (Model model : mark.getModels()) {
                modelRepo.addModel(model);
            }
        }
    }

    public Mark findMarkById(Long id) {
        return markRepo.findMarkById(id);
    }

    public void deleteMark(Mark mark) {
        markRepo.deleteMark(mark);
    }

    public void deleteMark(Long id) {
        markRepo.deleteMark(id);
    }

    public void printMarks() {
        markRepo.printMarks();
    }
}
