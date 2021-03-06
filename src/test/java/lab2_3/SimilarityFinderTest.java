package lab2_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

    SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());

    @Test
    public void isReturnedOneIfSequencesAreEmpty() {
        int[] seq1 = new int[0];
        int[] seq2 = new int[0];

        double similarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(similarity, is(1d));
    }

    @Test
    public void isReturnedZeroIfOneOfSequencesIsEmpty() {
        int[] seq1 = new int[0];
        int[] seq2 = new int[] {1, 2, 3};

        SequenceSearcherDoubler.suspectValues.add(false);
        SequenceSearcherDoubler.suspectValues.add(false);
        SequenceSearcherDoubler.suspectValues.add(false);

        double similarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(similarity, is(0d));

    }

    @Test
    public void isReturnedOneIfSequencesAreTheSame() {
        int[] seq1 = new int[] {1, 2, 3};
        int[] seq2 = new int[] {1, 2, 3};

        SequenceSearcherDoubler.suspectValues.add(true);
        SequenceSearcherDoubler.suspectValues.add(true);
        SequenceSearcherDoubler.suspectValues.add(true);

        double similarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(similarity, is(1d));
    }

    @Test
    public void isReturnedZeroForDifferentSequences() {
        int[] seq1 = new int[] {4, 5, 6};
        int[] seq2 = new int[] {1, 2, 3};

        SequenceSearcherDoubler.suspectValues.add(false);
        SequenceSearcherDoubler.suspectValues.add(false);
        SequenceSearcherDoubler.suspectValues.add(false);

        double similarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(similarity, is(0d));
    }

    @Test
    public void isReturnedIntersectionValueForSimillarSequences() {
        int[] seq1 = new int[] {1, 2, 3, 6};
        int[] seq2 = new int[] {1, 2, 3, 7};

        SequenceSearcherDoubler.suspectValues.add(true);
        SequenceSearcherDoubler.suspectValues.add(true);
        SequenceSearcherDoubler.suspectValues.add(true);
        SequenceSearcherDoubler.suspectValues.add(false);

        double similarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(similarity, is(0.6d));
    }

    @Test
    public void isReturnedAmountOfCallValueForSimillarSequences() {
        int[] seq1 = new int[] {1, 2, 3};
        int[] seq2 = new int[] {1, 4};

        SequenceSearcherDoubler.methodCallCounter = 0;
        double similarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(3, is(SequenceSearcherDoubler.methodCallCounter));
    }
}
