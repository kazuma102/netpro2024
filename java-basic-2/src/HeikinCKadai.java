import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[]args){
        Random rand = new Random(); 
        int maxPoint = 100;
        int studentNum = 100;
        int[] arr = new int[studentNum];
        
        //配列への代入
        for(int i = 0; i < arr.length; i++){
            Kamoku math = new Kamoku(rand.nextInt(maxPoint + 1));
            arr[i] = math.getScore();
        }

        //平均を求める
        int sum = 0;
        for(int a : arr){
            sum += a;
        }
        int avg = sum / studentNum;
        System.out.println("平均点は" + avg + "点です\n");

        //配列のソート
        Arrays.sort(arr);
        for(int a : arr){
            //System.out.println(a);
        }

        //合格者の点数表示
        System.out.println("以下、合格者の点数です\n");
        for(int a : arr){
            if(a >= 80) System.out.println(a + "点\n");
        }
    }
}
