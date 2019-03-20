package travelagency.user.service;

import travelagency.common.business.application.StorageType;
import travelagency.user.repo.impl.UserMemoryArrayRepo;
import travelagency.user.service.impl.UserDefaultService;

public final class UserServiceCreator {

    private UserServiceCreator() {

    }

    public static UserService getUserService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new UserDefaultService(new UserMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return null;
            }

            default: {
                return null;
            }
        }
    }
}
