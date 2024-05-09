public class XmasTreeKadai {
    public static void main(String[] args) {
        int n = 14;
        for (int i = 0; i < n; i++) {
            // 左側キラキラ
            int count = 0;
            for (int j = 0; j < n - i; j++) {
                if (count % 2 == 0) {
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
                count++;
            }

            // 葉っぱ
            for (int j = 0; j < i; j++) {
                System.out.print("**");
            }

            // 右側キラキラ
            count = 0;
            for (int j = 0; j < n - i; j++) {
                if (count % 2 == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("+");
                }
                count++;
            }

            System.out.println();
        }
        // 木の幹
        int length = 5;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }
    }
}