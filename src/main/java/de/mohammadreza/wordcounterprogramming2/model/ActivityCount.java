package de.mohammadreza.wordcounterprogramming2.model;

public class ActivityCount {
    private final ActivityType activityType;
    private final long count;

    public ActivityCount(ActivityType activityType, long count) {
        this.activityType = activityType;
        this.count = count;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public long getCount() {
        return count;
    }
}
