package autoservice.mark.service;

import autoservice.common.business.application.StorageType;
import autoservice.mark.repo.impl.MarkMemoryArrayRepo;
import autoservice.mark.service.impl.MarkDefaultService;
import autoservice.model.repo.impl.ModelMemoryArrayRepo;

public final class MarkServiceCreator {

    private MarkServiceCreator(){

    }

    public static MarkService getMarkService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new MarkDefaultService(new MarkMemoryArrayRepo(), new ModelMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return null;
            }

            default: {
                return null;
            }
        }
    }
}
