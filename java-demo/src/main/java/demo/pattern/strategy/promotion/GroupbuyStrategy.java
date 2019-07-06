package demo.pattern.strategy.promotion;

/**
 * 2019/3/13
 * zhouchao
 *
 * 策略模式
 */
public class GroupbuyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
