
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class HowOldAreYou {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader というのは、データ読み込みのクラス(型)
        // クラスの変数を作るには、new を使う。

        // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
        // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
        try {
            while (true) {
                System.out.println("何歳ですか?");
                String line = reader.readLine();
                if (line.equals("e") || line.equals("q")) {
                    System.out.println("終了します");
                    break;
                }

                int age = Integer.parseInt(line);
                if (age < 0 || age >= 120) {
                    System.out.println("年齢が正しくありません。もう一度入力してください");
                    continue;
                }

                int birthYear = LocalDate.now().getYear() - age;
                String birthEra = getBirthEra(birthYear);
                int age2030 = 2030 - birthYear;

                System.out.println("2030年のときの年齢は、" + age2030 + "歳");
                System.out.println("誕生年の元号は、" + birthEra);
                break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static String getBirthEra(int year) {
        String[] eraNames = { "明治", "大正", "昭和", "平成", "令和" };
        int[] eraStartYears = { 1868, 1912, 1926, 1989, 2019 };

        for (int i = eraStartYears.length - 1; i >= 0; i--) {
            if (year >= eraStartYears[i]) {
                return eraNames[i];
            }
        }
        return "不明";
    }
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
