package de.mohammadreza.wordcounterprogramming2.service.aggregator;

import de.mohammadreza.wordcounterprogramming2.model.ActivityType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.List;
import java.util.Map;

public class StreamActivityAggregatorTest {
    private ActivityAggregator aggregator;

    @BeforeEach
    void setUp() {
        aggregator = new StreamActivityAggregator();
    }

    @Test
    void aggregatorTest(){
        Map<ActivityType, Long> map1 = Map.of(
                ActivityType.FAHREN, 1L,
                ActivityType.ESSEN, 2L
        );

        Map<ActivityType, Long> map2 = Map.of(
                ActivityType.FAHREN, 2L
        );

        Map<ActivityType, Long> result = aggregator.aggregate(List.of(map1, map2));

        assertEquals(3, result.get(ActivityType.FAHREN));
        assertEquals(2, result.get(ActivityType.ESSEN));
    }

    @Test
    void shouldThrowExceptionForEmptyInput() {
        assertThrows(
                IllegalArgumentException.class,
                () -> aggregator.aggregate(List.of())
        );
    }
}
