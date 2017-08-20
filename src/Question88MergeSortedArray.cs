public class Question88MergeSortedArray
{
	public void Merge(int[] nums1, int m, int[] nums2, int n)
	{
        int i = m - 1;
        int j = n - 1;
        int total = m + n - 1;
        while (j >= 0)
        {
            nums1[total--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
	}
}