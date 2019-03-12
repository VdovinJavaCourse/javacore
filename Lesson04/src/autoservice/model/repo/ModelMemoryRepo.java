package autoservice.model.repo;

import autoservice.common.ArrayUtils;
import autoservice.model.Model;

import static autoservice.storage.Storage.models;

public class ModelMemoryRepo {

    private int modelIndex = -1;

    public void addModel(Model model) {
        if (modelIndex == models.length - 1) {
            Model[] newArrModels = new Model[models.length * 2];
            System.arraycopy(models, 0, newArrModels, 0, models.length);
            models = newArrModels;
        }
        modelIndex++;
        models[modelIndex] = model;
    }

    public Model findModelById(long id) {
        Integer foundIndex = findModelIndexById(id);
        if (foundIndex != null) {
            return models[foundIndex];
        }
        return null;
    }

    private Integer findModelIndexById(Long modelId) {
        for (int i = 0; i < models.length; i++) {
            if (models[i].getId().equals(modelId)) {
                return i;
            }
        }
        return null;
    }

    public void printModels() {
        for (Model model : models) {
            System.out.println(model);
        }
    }

    public void deleteModel(Model model) {
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
    }

    public void deleteModel(Long id){
        Integer foundIndex = findModelIndexById(id);

        if(foundIndex!=null){
            deleteModelByIndex(foundIndex);
        }
    }

    private void deleteModelByIndex(int index){
        ArrayUtils.removeElement(models,index);
        modelIndex--;
    }
}
