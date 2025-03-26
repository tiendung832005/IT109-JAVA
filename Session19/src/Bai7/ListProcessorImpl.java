package Bai7;

import java.util.List;
import java.util.function.Predicate;

class ListProcessorImpl implements ListProcessor {
    @Override
    public boolean containsNegative(List<Integer> list) {
        for (Integer num : list) {
            if (num < 0) {
                return true;
            }
        }
        return false;
    }
}
