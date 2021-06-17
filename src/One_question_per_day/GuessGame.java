package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/17 10:17 上午
 * @Description
 */
public class GuessGame {
    int pick;

    /**
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    int guess(int num) {
        if (pick < num) {
            return -1;
        } else if (pick > num) {
            return 1;
        } else {
            return pick;
        }
    }
}
