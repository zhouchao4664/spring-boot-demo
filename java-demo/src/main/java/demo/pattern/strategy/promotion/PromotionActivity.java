package demo.pattern.strategy.promotion;

/**
 * 2019/3/13
 * zhouchao
 *
 * 策略模式
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute() {
        promotionStrategy.doPromotion();
    }
}
