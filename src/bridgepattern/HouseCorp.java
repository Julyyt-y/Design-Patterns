package bridgepattern;

/**
 * 房地产公司
 */
public class HouseCorp extends Corp{

    //定义传递一个产品House进来
    public HouseCorp(House house){
        super(house);
    }

    //赚钱
    public void makeMoney(){
        super.makeMoney();
        System.out.println("房地产公司挣钱");
    }
}
