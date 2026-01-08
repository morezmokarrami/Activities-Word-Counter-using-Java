package de.mohammadreza.wordcounterprogramming2.service.provider;

import de.mohammadreza.wordcounterprogramming2.model.Activity;
import de.mohammadreza.wordcounterprogramming2.model.ActivitySequence;
import de.mohammadreza.wordcounterprogramming2.model.ActivityType;

import java.util.List;

public class InMemorySequenceProvider implements ActivitySequenceProvider {

    @Override
    public List<ActivitySequence> getSequence() {
        ActivitySequence sequence1 = new ActivitySequence(
                List.of(
                        new Activity(ActivityType.ARBEITEN),
                        new Activity(ActivityType.LADEN),
                        new Activity(ActivityType.FAHREN)
                )
        );
        ActivitySequence sequence2 = new ActivitySequence(
                List.of(
                        new Activity(ActivityType.ESSEN),
                        new Activity(ActivityType.ESSEN),
                        new Activity(ActivityType.FAHREN)
                )
        );
        ActivitySequence sequence3 = new ActivitySequence(
                List.of(
                        new Activity(ActivityType.LADEN),
                        new Activity(ActivityType.FAHREN)
                )
        );

        return List.of(
                sequence1,
                sequence2,
                sequence3
        );
    }
}

