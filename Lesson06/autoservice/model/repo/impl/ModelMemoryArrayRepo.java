package autoservice.model.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import autoservice.model.domain.Model;
import autoservice.model.repo.ModelRepo;
import autoservice.model.search.ModelSearchCondition;

import java.util.Collections;
import java.util.List;

import static autoservice.storage.Storage.modelsArray;

public class ModelMemoryArrayRepo implements ModelRepo {
    private static final Model[] EMPTY_MODELS_ARR = new Model[0];
    private int modelIndex = -1;

    public void add(Model model) {
        if (modelIndex == modelsArray.length - 1) {
            Model[] newArrModels = new Model[modelsArray.length * 2];
            System.arraycopy(modelsArray, 0, newArrModels, 0, modelsArray.length);
            modelsArray = newArrModels;
        }
        modelIndex++;
        modelsArray[modelIndex] = model;
    }

    public Model findById(long id) {
        Integer foundIndex = findModelIndexById(id);
        if (foundIndex != null) {
            return modelsArray[foundIndex];
        }
        return null;
    }

    private Integer findModelIndexById(Long modelId) {
        for (int i = 0; i < modelsArray.length; i++) {
            if (modelsArray[i] != null && modelsArray[i].getId().equals(modelId)) {
                return i;
            }
        }
        return null;
    }

    public void printAll() {
        for (Model model : modelsArray) {
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
        for (int i = 0; i < modelsArray.length; i++) {
            if (modelsArray[i].equals(model)) {
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
        ArrayUtils.removeElement(modelsArray, index);
        modelIndex--;
    }


    @Override
    public List<Model> search(ModelSearchCondition searchCondition) {
        return Collections.emptyList();
    }

}
