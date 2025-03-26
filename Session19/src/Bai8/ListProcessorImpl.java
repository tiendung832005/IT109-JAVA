package Bai8;

import java.util.List;

class ListProcessorImpl implements ListProcessor {
    @Override
    public int sumOddNumbers(List<Integer> list) {
        return list.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
