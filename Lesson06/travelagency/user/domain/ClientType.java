package travelagency.user.domain;

public enum ClientType {

    VIP("Very important person"),
    NEW("First time visited our service"),
    BAD("Bad behaviour"),
    ORDINARY("Just another client"),
    IN_THE_BLACK_LIST("Ignore him");

    private String description;

    ClientType(String description) {
        this.description = description;
    }
    }
