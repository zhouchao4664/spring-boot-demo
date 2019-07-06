package demo.pattern.strategy.promotion;

/**
 * 2019/3/13
 * zhouchao
 *
 * 策略模式
 */
public class PromotionActivityTest {
    public static void main(String[] args) {
        PromotionActivityTest.test1();
    }

    public static void test1(){
        PromotionActivity promotionActivity618 = new PromotionActivity(new CouponStrategy());
        PromotionActivity promotionActivity1111= new PromotionActivity(new CashbackStrategy());

        promotionActivity618.execute();
        promotionActivity1111.execute();
    }

    public static void test2(){
        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";

    }
}
