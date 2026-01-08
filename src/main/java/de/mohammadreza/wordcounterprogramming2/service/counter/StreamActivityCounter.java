package de.mohammadreza.wordcounterprogramming2.service.counter;

import de.mohammadreza.wordcounterprogramming2.model.Activity;
import de.mohammadreza.wordcounterprogramming2.model.ActivitySequence;
import de.mohammadreza.wordcounterprogramming2.model.ActivityType;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamActivityCounter implements ActivityCounter {

    @Override
    public Map<ActivityType, Long> count(ActivitySequence sequence) {

        // Sequence must not be null
        if (sequence == null) {
            throw new IllegalArgumentException("Sequence must not be null");
        }

        return sequence.getActivities()
                .stream()
                .map(Activity::getActivityType)
                .collect(Collectors.groupingBy(
                activityType -> activityType,
                Collectors.counting()
        ));
    }
}
