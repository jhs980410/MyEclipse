
package hk.exam.ten2;

public class UpDownGameRule implements GameRule {
    @Override
    public boolean isCorrect(int guess, int target) {
        return guess == target;
    }
}

