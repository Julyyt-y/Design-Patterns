package adapterpattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        //没有与外系统联系的时候
        IUserInfo young = new UserInfo();
        //从数据库中查到101个
        for (int i=0;i<101;i++){
            young.getMobileNumber();
        }

        //借用外部人员
        IUserInfo young1 = new OuterUserInfo();
        for (int i=0;i<101;i++){
            young1.getMobileNumber();
        }
    }
}
