package demo.leecode.medium;

/**
 * @Author zhouchao
 * @Date 2020/11/18 18:28
 * @Description
 **/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int max = 0;
        int j = height.length - 1;
        for (int i = 0; i != j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

}
