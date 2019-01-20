package bridgepattern;

/**
 * 服装公司
 */
public class ClothesCorp extends Corp{

    //定义传递一个产品Clothes进来
    public ClothesCorp(Clothes clothes){
        super(clothes);
    }

    //赚钱
    public void makeMoney(){
        super.makeMoney();
        System.out.println("服装公司挣钱");
    }
}
