package autoservice.user.service;

import autoservice.common.business.application.StorageType;
import autoservice.user.repo.impl.UserMemoryArrayRepo;
import autoservice.user.service.UserService;
import autoservice.user.service.impl.UserDefaultService;

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
