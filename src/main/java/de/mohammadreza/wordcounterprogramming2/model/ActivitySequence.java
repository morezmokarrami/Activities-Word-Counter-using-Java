package de.mohammadreza.wordcounterprogramming2.model;

import java.util.List;

public class ActivitySequence {
    private final List<Activity> activities;

    public ActivitySequence(List<Activity> activities) {
        if (activities == null || activities.isEmpty()) {
            throw new IllegalArgumentException("ActivitySequence must contain at least one Activity");
        }
        this.activities = activities;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return activities.toString();
    }
}
