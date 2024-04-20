import java.math.BigInteger;
import java.util.Random;

public class NetproLabMember {
    public static final int years = 15;
    public static final int gen = 3;

    public static void main(String[] args) {
        int[][] members = new int[years][gen];
        Random random = new Random();

        double totalRate = 1;
        for (int i = 0; i < years; i++) {
            //学生の総数
            members[i][0] = 110 + (random.nextInt(20) - 10);
            //女性の割合
            members[i][1] = (int) members[i][0] * (20 + i) / 100;
            //岩井研の人数
            members[i][2] = 10 + (random.nextInt(6) - 3);

            //男性数を求める
            int menNum = members[i][0] - (int) (members[i][0] * ((float) members[i][1] / 100));
            //総数から岩井研の人数を取り出す組み合わせ
            BigInteger cpsRate = combination(members[i][0], members[i][2]);
            //男性の中から岩井研のメンバーを取り出す組み合わせ
            BigInteger menRate = combination(menNum, members[i][2]);
            /*
            System.out.println(i+1 + " : " + members[i][2]);
            System.out.println(menRate);
            System.out.println(cpsRate);
            */
            //岩井研の人数に男性しかはいらない割合
            totalRate *= menRate.doubleValue() / cpsRate.doubleValue();
        }
        System.out.println(totalRate);
    }

    public static final BigInteger combination(final int n, int r) {
        if (r > n) {
            return BigInteger.ZERO;
        }

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        numerator = factorial(n);
        denominator = factorial(r).multiply(factorial(n - r));

        // System.out.println("n = " + n);
        // System.out.println("r = " + r);
        // System.out.println("n! = " + factorial(n));
        // System.out.println("r! = " + factorial(r));
        // System.out.println("(n-r)! = " + factorial(n - r));

        return numerator.divide(denominator);
    }

    static BigInteger factorial(int n) {
        BigInteger fa = BigInteger.ONE;
        fa = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            fa = fa.multiply(BigInteger.valueOf(i));
            // System.out.println("fa = " + fa);
        }
        return fa;
    }
}
