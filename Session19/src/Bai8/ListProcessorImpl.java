package Bai8;

import java.util.List;

class ListProcessorImpl implements ListProcessor {
    @Override
    public boolean checkOdd(List<Integer> list) {
        for (Integer num : list) {
            if (num % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int sumOddNumbers(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }
}
