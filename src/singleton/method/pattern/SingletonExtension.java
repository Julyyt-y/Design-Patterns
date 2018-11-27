package singleton.method.pattern;

import java.util.ArrayList;
import java.util.Random;

/**
 * 单例模式的扩展：
 * 一个类中有多个实例（但数量固定不变）；
 * 用容器（集合）管理这些实例。
 */
class SingletonExtension {

    //定义能产生更多实例的数量，此处假设为2
    private static int maxInstance = 2;

    //存放这些实例的名字的集合
    private static ArrayList<String> instanceNames = new ArrayList<>();

    //存放这些实例的集合
    private static ArrayList<SingletonExtension> instanceList = new ArrayList<>();

    //当前实例的序号
    private static int countNumOfInstance = 0;

    //产生所有实例
    static {
        for (int i=0;i<maxInstance;i++){
            instanceList.add(new SingletonExtension("第" + (i + 1) + "个实例"));
        }
    }

    private SingletonExtension(){ }

    private SingletonExtension(String name){
        instanceNames.add(name);
    }

    public static SingletonExtension getInstance(){
        Random random = new Random();
        //随机取出一个实例
        countNumOfInstance = random.nextInt(maxInstance);
        return instanceList.get(countNumOfInstance);
    }

    //其他方法
    public static void function(){
        System.out.println("我是第" + countNumOfInstance +"个实例");
    }
}

//其他类，这个类要创建SingletonExtension类的实例
class Other{
    public static void main(String[] args){
        int count = 5;
        for (int i=0;i<count;i++){
            SingletonExtension instance = SingletonExtension.getInstance();
            instance.function();
        }
    }
}