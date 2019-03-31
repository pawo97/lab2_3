package lab2_3;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    @Override
    public SearchResult search(int key, int[] seq) {
        Builder builder = SearchResult.builder();
        for (int elem : seq) {
            if (elem == key) {
                builder.withFound(true);
            }
        }
        return builder.build();
    }

}
