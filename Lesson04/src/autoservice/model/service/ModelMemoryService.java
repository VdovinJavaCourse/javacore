package autoservice.model.service;

import autoservice.model.Model;
import autoservice.model.repo.ModelMemoryRepo;

public class ModelMemoryService {

    private ModelMemoryRepo modelRepo = new ModelMemoryRepo();

    public void addModel(Model model) {
        modelRepo.addModel(model);
    }

    public Model findModelById(Long id) {
        return modelRepo.findModelById(id);
    }

    public void deleteModel(Model model) {
        modelRepo.deleteModel(model);
    }

    public void deleteModel(Long id) {
        modelRepo.deleteModel(id);
    }

    public void printModels() {
        modelRepo.printModels();
    }
}
