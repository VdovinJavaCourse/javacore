package autoservice.model.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import autoservice.model.domain.Model;
import autoservice.model.repo.ModelRepo;
import autoservice.model.search.ModelSearchCondition;

import static autoservice.storage.Storage.models;

public class ModelMemoryArrayRepo implements ModelRepo {
    private static final Model[] EMPTY_MODELS_ARR = new Model[0];
    private int modelIndex = -1;

    public void add(Model model) {
        if (modelIndex == models.length - 1) {
            Model[] newArrModels = new Model[models.length * 2];
            System.arraycopy(models, 0, newArrModels, 0, models.length);
            models = newArrModels;
        }
        modelIndex++;
        models[modelIndex] = model;
    }

    public Model findById(long id) {
        Integer foundIndex = findModelIndexById(id);
        if (foundIndex != null) {
            return models[foundIndex];
        }
        return null;
    }

    private Integer findModelIndexById(Long modelId) {
        for (int i = 0; i < models.length; i++) {
            if (models[i] != null && models[i].getId().equals(modelId)) {
                return i;
            }
        }
        return null;
    }

    public void printAll() {
        for (Model model : models) {
            if (model != null) {
                System.out.println(model);
            }
        }
    }

 /*   public void deleteModel(Model model) {
        Integer foundIndex = findModelIndexByEntity(model);

        if (foundIndex != null) {
            deleteModelByIndex(foundIndex);
        }
    }

    private Integer findModelIndexByEntity(Model model) {
        for (int i = 0; i < models.length; i++) {
            if (models[i].equals(model)) {
                return i;
            }
        }
        return null;
    }*/

    public void deleteById(Long id) {
        Integer foundIndex = findModelIndexById(id);

        if (foundIndex != null) {
            deleteModelByIndex(foundIndex);
        }
    }

    private void deleteModelByIndex(int index) {
        ArrayUtils.removeElement(models, index);
        modelIndex--;
    }


    @Override
    public Model[] search(ModelSearchCondition searchCondition) {
        return EMPTY_MODELS_ARR;
    }

}
