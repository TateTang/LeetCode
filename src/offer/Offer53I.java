package offer;

/**
 * @Author tangmf
 * @Date 2021/9/2 4:42 下午
 * @Description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class Offer53I {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(new Offer53I().search(nums, target));
    }

    public int search(int[] nums, int target) {
        //找到目标值「最后」出现的分割点，并「往前」进行统计
        int l = 0, r = nums.length - 1;
        //找到target的最后一个出现的值
        while (l < r) {
            int mid = l + r + 1 >> 1;//等价于(l+r+1)/2
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        int ans = 0;
        //[往前]进行统计，r-- 且 nums[r] == target
        while (r >= 0 && nums[r] == target) {
            r--;
            ans++;
        }
        return ans;
    }

    public int search1(int[] nums, int target) {
        //找到目标值「首次」出现的分割点，并「往后」进行统计
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;//等价于(l+r+1)/2
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int ans = 0;
        while (l < nums.length && nums[l] == target) {
            l++;
            ans++;
        }
        return ans;
    }

    public int search2(int[] nums, int target) {
        /*
        二分两边
         进一步，我们可以直接经过两次「二分」找到左右边界，计算总长度即是 target 的数量。
         */
        int n = nums.length;
        if (n == 0) return 0;
        int a, b;
        // 二分出左边界
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[r] != target) return 0;
        a = r;
        // 二分出右边界
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        if (nums[r] != target) return 0;
        b = r;
        return b - a + 1;
    }
}
