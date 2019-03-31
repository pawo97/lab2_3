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

}
