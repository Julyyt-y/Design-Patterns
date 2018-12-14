package chainofresponsibilitypattern;

import java.util.ArrayList;
import java.util.Random;

public class Client {
    public static void main(String[] args){
        //随机挑选几个古代妇女
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i=0;i<5;i++){
            arrayList.add(new Women(random.nextInt(4),"我要去逛街"));
        }
        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        //设置请示顺序
        father.serNext(husband);
        husband.serNext(son);
        for (IWomen women : arrayList){
            father.HandleMessage(women);
        }
    }
}
