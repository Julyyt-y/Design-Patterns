package mediatorpattern;

import java.util.Random;

/**
 * 销售管理
 */
public class Sale {
    //销售IBM电脑
    public void sellIBMComputer(int number){
        //访问库存
        Stock stock = new Stock();
        //访问采购
        Purchase purchase = new Purchase();
        //库存数量不够销售时
        if (stock.getStockNumber() < number){
            purchase.buyIBMcomputer(number);
        }
        System.out.println("销售IBM电脑：" +number + "台。");
        stock.decrease(number);
    }
    //反馈销售情况，0-100之间变化，0代表没有售出
    public int getSaleStstue(){
        Random rand = new Random(System.currentTimeMillis());
        int saleStatue = rand.nextInt(100);
        System.out.println("IBM电脑的销售情况为：" + saleStatue);
        return saleStatue;
    }
    //折价处理
    public void offSale(){
        //库房有多少卖多少
        Stock stock = new Stock();
        System.out.println("折价销售IBM电脑" + stock.getStockNumber() + "台。");
    }
}
