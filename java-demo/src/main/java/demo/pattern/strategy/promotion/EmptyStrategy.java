package demo.pattern.strategy.promotion;

/**
 * 2019/3/13
 * zhouchao
 *
 * 策略模式
 *
 * 无优惠
 */
public class EmptyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无优惠活动");
    }
}
