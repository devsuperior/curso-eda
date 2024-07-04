import java.util.Arrays;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n]; // 0 for UNKNOWN

        // -1 for UNKNOWN, 1 for GOOD, 0 for BAD
        Arrays.fill(memo, -1);
        memo[n - 1] = 1; // Last position is marked as GOOD

        // Função recursiva com memoização
        return canJumpFromPosition(nums, memo, 0);
    }

    private static boolean canJumpFromPosition(int[] nums, int[] memo, int position) {
        if (memo[position] != -1) {
            return memo[position] == 1;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nums, memo, nextPosition)) {
                memo[position] = 1; // Mark as GOOD
                return true;
            }
        }

        memo[position] = 0; // Mark as BAD
        return false;
    }

    public static void main(String[] args) {
        // Testes
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));
    }
}
