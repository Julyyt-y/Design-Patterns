package bridgepattern;

/**
 * 山寨公司
 */
public class ShanzhaiCorp extends Corp{
    //定义传递一个产品House进来
    public ShanzhaiCorp(Product product){
        super(product);
    }

    //赚钱
    public void makeMoney(){
        super.makeMoney();
        System.out.println("山寨公司挣钱");
    }
}
