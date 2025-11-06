package two_pointer;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int currentWaterCapacity = 0;
        int low = 0, high = height.length - 1;
        int mostWaterCapacity = 0;
        while (low < high) {
            if (height[low] < height[high]) {
                currentWaterCapacity = height[low] * (high - low);
                low++;
            } else {
                currentWaterCapacity = height[high] * (high - low);
                high--;
            }
            if (currentWaterCapacity > mostWaterCapacity) {
                mostWaterCapacity = currentWaterCapacity;
            }
        }
        return mostWaterCapacity;
    }
}
