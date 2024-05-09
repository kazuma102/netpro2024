public class NoHolidayException extends Exception {


    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("報酬の課題だ…持っていきたまえ\r\n" + //
                        "　　　　　　　　∧＿∧\r\n" + //
                        "　　　　　　　⊂(･ω･`)つ-､\r\n" + //
                        "　　　　　　課題/　　/_/　|\r\n" + //
                        "　　　 　　 課題ヽノ L|／\r\n" + //
                        "　　　 ／￣ 課題 ￣￣／|\r\n" + //
                        "　　／＿＿＿＿＿＿／ | |\r\n" + //
                        "　　||―――――ｰ||");
    }
}