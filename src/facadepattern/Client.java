package facadepattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        //现代化邮局，
        ModenPostOffice office = new ModenPostOffice();
        //定义一个地址
        String address = "XXX road No.000 XXXXXX";
        String cobtext = "Hello, It is me.......";
        //一体化邮局寄信
        office.sendLetter(cobtext,address);
    }
}
