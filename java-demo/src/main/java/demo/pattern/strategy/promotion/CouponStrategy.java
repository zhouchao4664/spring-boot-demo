package demo.pattern.strategy.promotion;

/**
 * 2019/3/13
 * zhouchao
 *
 * 策略模式
 *
 * 无优惠
 */
public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程价格直接减去优惠券面值抵扣");
    }
}
