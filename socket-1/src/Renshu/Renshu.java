package Renshu;
public class Renshu {
    public int doubleValue(int x) {
        return x * 2;
    }

    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q) {
        if (p > q)
            return -1;
        int sum = 0;
        for (int i = p; i <= q; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromArrayIndex(int[] a, int index) {
        if (index > a.length - 1)
            return -1;
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    public int selectMaxIndex(int[] a) {
        int index = 0;
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }

    public int selectMinIndex(int[] a) {
        int index = 0;
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    public void swapArrayElements(int[] p, int i, int j) {
        int prev = p[i];
        p[i] = p[j];
        p[j] = prev;
    }

    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            System.out.println("配列の長さが一致していません");
            return false;
        }
        for(int i = 0; i < a.length; i++){
            int prev = a[i];
            a[i] = b[i];
            b[i] = prev;
        }
        return true;
    }
}
