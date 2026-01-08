package de.mohammadreza.wordcounterprogramming2.service.counter;

import de.mohammadreza.wordcounterprogramming2.model.Activity;
import de.mohammadreza.wordcounterprogramming2.model.ActivitySequence;
import de.mohammadreza.wordcounterprogramming2.model.ActivityType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.List;
import java.util.Map;

public class StreamActivityCounterTest {
    private ActivityCounter counter;

    @BeforeEach
    void setUp() {
            counter = new StreamActivityCounter();
    }

    @Test
    void countActivities() {
        ActivitySequence sequence = new ActivitySequence(
                List.of(
                        new Activity(ActivityType.ESSEN),
                        new Activity(ActivityType.ESSEN),
                        new Activity(ActivityType.LADEN)
                )
        );

        Map<ActivityType, Long> result = counter.count(sequence);

        assertEquals(2, result.get(ActivityType.ESSEN));
        assertEquals(1, result.get(ActivityType.LADEN));
    }

    @Test
    void shouldThrowExceptionForNullSequence() {
        assertThrows(
                IllegalArgumentException.class,
                () -> counter.count(null)
        );
    }
}
