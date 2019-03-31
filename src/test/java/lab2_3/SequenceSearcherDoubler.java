package lab2_3;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    public static int methodCallCounter = 0;

    @Override
    public SearchResult search(int key, int[] seq) {
        Builder builder = SearchResult.builder();
        methodCallCounter++;
        int position = 0;
        for (int elem : seq) {
            if (elem == key) {
                builder.withFound(true);
                builder.withPosition(position);
            }
            position++;
        }
        return builder.build();
    }

}
