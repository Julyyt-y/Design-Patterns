package bridgepattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        House house = new House();
        System.out.println("房地产公司：");
        HouseCorp houseCorp = new HouseCorp(house);
        houseCorp.makeMoney();
        System.out.println("\n");
        Clothes clothes = new Clothes();
        System.out.println("服装公司：");
        ClothesCorp clothesCorp = new ClothesCorp(clothes);
        clothesCorp.makeMoney();
        System.out.println("山寨公司：");
        ShanzhaiCorp shanzhaiCorp = new ShanzhaiCorp(new iPod());
        shanzhaiCorp.makeMoney();
    }
}
