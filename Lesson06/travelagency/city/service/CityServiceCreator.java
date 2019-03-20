package travelagency.city.service;

import travelagency.city.repo.impl.CityMemoryArrayRepo;
import travelagency.city.service.impl.CityDefaultService;
import travelagency.common.business.application.StorageType;

public final class CityServiceCreator {

    private CityServiceCreator(){

    }

    public static CityService getCityService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new CityDefaultService(new CityMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return null;
            }

            default: {
                return null;
            }
        }
    }
}
