package de.mohammadreza.wordcounterprogramming2.model;

public class Activity {
    private final ActivityType activityType;

    public Activity(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    @Override
    public String toString() {
        return activityType.name();
    }
}
