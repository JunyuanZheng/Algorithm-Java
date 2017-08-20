package easy;

public class Question11ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (Math.min(height[l], height[r]) * (r - l) > max) {
                max = Math.min(height[l], height[r]) * (r - l);
            }
            if (height[l] > height[r]) {
                int i = r - 1;
                while (i > 0 && height[i] < height[r]) {
                    i -= 1;
                }
                r = i;
            } else {
                int i = l + 1;
                while (i < height.length - 1 && height[i] < height[l]) {
                    i += 1;
                }
                l = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
