package de.mohammadreza.wordcounterprogramming2.service.aggregator;

import de.mohammadreza.wordcounterprogramming2.model.Activity;
import de.mohammadreza.wordcounterprogramming2.model.ActivityType;

import java.util.List;
import java.util.Map;

public interface ActivityAggregator {
    Map<ActivityType, Long> aggregate(List<Map<ActivityType, Long>> counts);
}
