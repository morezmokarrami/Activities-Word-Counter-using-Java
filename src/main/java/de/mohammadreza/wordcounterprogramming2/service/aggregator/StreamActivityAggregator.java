package de.mohammadreza.wordcounterprogramming2.service.aggregator;

import de.mohammadreza.wordcounterprogramming2.model.ActivityType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamActivityAggregator implements ActivityAggregator{

    @Override
    public Map<ActivityType, Long> aggregate(List<Map<ActivityType, Long>> counts) {

        if (counts == null || counts.isEmpty()) {
            throw new IllegalArgumentException("Counts must not be null or empty");
        }

        return counts.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingLong(Map.Entry::getValue)
                ));
    }
}
