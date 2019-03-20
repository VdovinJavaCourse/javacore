package autoservice.model.service;

import autoservice.common.business.application.StorageType;
import autoservice.model.repo.impl.ModelMemoryArrayRepo;
import autoservice.model.service.impl.ModelDefaultService;

public final class ModelServiceCreator {

    private ModelServiceCreator(){

    }

    public static ModelService getModelService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new ModelDefaultService(new ModelMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return null;
            }

            default: {
                return null;
            }
        }
    }
}
