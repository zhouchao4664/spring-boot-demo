package demo.pattern.strategy.promotion;

/**
 * 2019/3/13
 * zhouchao
 *
 * 策略模式
 *
 * 无优惠
 */
public class CashbackStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额直接转到支付宝账号");
    }
}
