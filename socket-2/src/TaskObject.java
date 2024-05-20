
import java.io.Serializable;

public class TaskObject implements ITask, Serializable {

    int num = 0;
    int result = 0;

    public void setExecNumber(int num) {
        this.num = num;
    }

    public void exec() {
        if (num <= 1) {
            // 1以下の値が入力された場合、終了する
            System.out.println("1以下の値が入力されたため、処理を終了します。");
            return;
        }
        this.result = nextNum(num);
    }

    public int getResult() {
        return result;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // 2と3の倍数以外の奇数を確認
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // 6k ± 1の形の数のみを確認
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private int nextNum(int num) {
        if (isPrime(num)) {
            return num;
        } else {
            return nextNum(num - 1);
        }
    }
}
