package de.mohammadreza.wordcounterprogramming2.service.counter;

import de.mohammadreza.wordcounterprogramming2.model.ActivitySequence;
import de.mohammadreza.wordcounterprogramming2.model.ActivityType;

import java.util.Map;

public interface ActivityCounter {
    Map<ActivityType, Long> count(ActivitySequence sequence);
}
