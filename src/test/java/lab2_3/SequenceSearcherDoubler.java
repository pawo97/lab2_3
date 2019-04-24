package lab2_3;

import java.util.Vector;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    public static int methodCallCounter = 0;
    public static Vector<Boolean> suspectValues = new Vector<>();
    public static int vectorSize;
    public static int keyToSearch;

    @Override
    public SearchResult search(int key, int[] seq) {
        Builder builder = SearchResult.builder();
        methodCallCounter++;

        builder.withFound(suspectValues.get(0));
        suspectValues.remove(0);

        return builder.build();
    }

}
