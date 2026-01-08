package de.mohammadreza.wordcounterprogramming2.app;

import de.mohammadreza.wordcounterprogramming2.model.ActivityCount;
import de.mohammadreza.wordcounterprogramming2.model.ActivitySequence;
import de.mohammadreza.wordcounterprogramming2.model.ActivityType;
import de.mohammadreza.wordcounterprogramming2.service.aggregator.ActivityAggregator;
import de.mohammadreza.wordcounterprogramming2.service.aggregator.StreamActivityAggregator;
import de.mohammadreza.wordcounterprogramming2.service.counter.ActivityCounter;
import de.mohammadreza.wordcounterprogramming2.service.counter.StreamActivityCounter;
import de.mohammadreza.wordcounterprogramming2.service.provider.ActivitySequenceProvider;
import de.mohammadreza.wordcounterprogramming2.service.provider.InMemorySequenceProvider;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // 1- Provider
        ActivitySequenceProvider provider = new InMemorySequenceProvider();

        //2- Counter
        ActivityCounter counter = new StreamActivityCounter();

        //3- Aggregator
        ActivityAggregator aggregator = new StreamActivityAggregator();

        //4- Get Sequence
        List<ActivitySequence> sequences = provider.getSequence();

        //5- Count each Sequence
        List<Map<ActivityType, Long>> counts = sequences.stream()
                .map(counter::count)
                .toList();

        // 6. Aggregate all results
        Map<ActivityType, Long> result = aggregator.aggregate(counts);

        //7- Print the Result
        List<ActivityCount> output = result.entrySet()
                .stream()
                .map(e -> new ActivityCount(e.getKey(), e.getValue()))
                .toList();

        output.forEach(ac ->
                System.out.println(ac.getActivityType() + " -> " + ac.getCount())
        );
    }
}
