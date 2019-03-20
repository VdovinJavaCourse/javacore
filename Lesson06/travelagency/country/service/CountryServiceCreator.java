package travelagency.country.service;

import travelagency.city.repo.impl.CityMemoryArrayRepo;
import travelagency.common.business.application.StorageType;
import travelagency.country.repo.impl.CountryMemoryArrayRepo;
import travelagency.country.service.impl.CountryDefaultService;

public final class CountryServiceCreator {

    private CountryServiceCreator(){

    }

    public static CountryService getCountryService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new CountryDefaultService(new CountryMemoryArrayRepo(), new CityMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return null;
            }

            default: {
                return null;
            }
        }
    }

}
