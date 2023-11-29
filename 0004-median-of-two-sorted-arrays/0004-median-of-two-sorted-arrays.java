class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, fp = 0;
        int s1 = nums1.length, s2 = nums2.length, size = s1 + s2;
        int[] finalArr = new int[size];
        
        while(p1 != s1 && p2 != s2) {
            if(nums1[p1] < nums2[p2]){
                finalArr[fp] = nums1[p1];
                p1++;
                fp++;
            } else {
                finalArr[fp] = nums2[p2];
                p2++;
                fp++;
            }

        }

        while (p1 < s1) {
            finalArr[fp] = nums1[p1];
            p1++;
            fp++;
        }
        while (p2 < s2) {
            finalArr[fp] = nums2[p2];
            p2++;
            fp++;
        }

        double ans = 0;
        int l = finalArr.length;
        ans = (l%2 == 0) ? ((float)(finalArr[l/2 - 1] + finalArr[l/2]) / 2) : ((float)finalArr[finalArr.length/2 ]);
        System.out.println(ans);
        return ans;
    }
}