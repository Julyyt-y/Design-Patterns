package factorymethodpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法模式的扩展（4）——延迟初始化
 * 延迟初始化：
 * 一个对象被消费完毕后，并不立即释放，工厂类保持其初始状态，等待再次被使用；
 *
 * 具体实现：
 * 定义一个Map容器容纳所有对象，如果在Map中已经有的对象，则直接取出返回；
 * 如果没有，则根据需要的类型产生一个对象并放入Map容器中，以方便下次调用。
 *
 */

//延迟加载的工厂类，public
class ProductFactory{
    //定义一个Map容器容纳所有对象
    private static final Map<String,Goods2> prMap = new HashMap<>();
    public static synchronized Goods2 creatrProduct(String type) throws Exception{
        Goods2 goods = null;
        //如果Map中已经有这个对象
        if (prMap.containsKey(type)){
            goods = prMap.get(type);
        }else {
            if (type.equals("Goods1")){
                goods = (Goods2) new GoodsA2Factory();
            }else {
                goods = (Goods2) new GoodsB2Factory();
            }
            //同时把对象放到缓存容器中
            prMap.put(type,goods);
        }
        return goods;
    }
}

class FactoryMethodExtension4 {
}
