package autoservice.model.service.impl;

import autoservice.model.domain.Model;
import autoservice.model.repo.ModelRepo;
import autoservice.model.repo.impl.ModelMemoryArrayRepo;
import autoservice.model.search.ModelSearchCondition;
import autoservice.model.service.ModelService;

import java.util.List;

public class ModelDefaultService implements ModelService {

    private final ModelRepo modelRepo;

    public ModelDefaultService(ModelRepo modelRepo) {
        this.modelRepo = modelRepo;
    }

    public void add(Model model) {
        if (model != null) {
            modelRepo.add(model);
        }
    }

    public Model findById(Long id) {
        if (id != null) {
            return modelRepo.findById(id);
        } else {
            return null;
        }

    }

    public void delete(Model model) {
        if (model.getId() != null) {
            this.deleteById(model.getId());
        }
    }

    @Override
    public List<Model> search(ModelSearchCondition searchCondition) {
       return modelRepo.search(searchCondition);
    }

    /*@Override
    public Model[] search(ModelSearchCondition searchCondition) {
        return new Model[0];
    }*/

    public void deleteById(Long id) {
        if (id != null) {
            modelRepo.deleteById(id);
        }
    }

    public void printAll() {
        modelRepo.printAll();
    }
}
