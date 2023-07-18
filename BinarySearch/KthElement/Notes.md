### Question
- Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the kth position of the final sorted array.

### Sample Input
    m=5 n=4 k=3
    arr1 = 3 11 23 45 52
    arr2 = 4 12 14 18

    m=5 n=4 k=3
    arr1 = 1 3 6 7 10
    arr2 = 3 5 5 7

### Sample Output
    11
    3

### Solution
- First of all we will ensure, we are always partitioning the smaller arr
- Take two pointers in the smaller arr, and we need to partition in such a way that the last element of left part will be the kth element
- do binary search, we will try to partition both the arrays in such a way, that left partitions of both arrays will be lesser than right partition of both arrays
- Now make a cut1 on mid of smaller arr, to ensure we have k elements on both sides, we need k-cut1 element more on left side, cut2 will be equal to k-cut1
- now we need to mark l1,l2,r1,r2 -> l1 will be last element before cut1 is made, similarly l2 will be last element before cut2 is made
- r1 will be first element after cut1 is made, similarly r2 is first element after cut2 is made
- if(l1<=r2 && l2<=r1) i.e., all the elements to left are less than all the elements to right, then just return the max(l1,l2)
- else if (l1>r2), this means, we need to reduce l1 and increase r2, to do that we will shift high to cut1-1 position
- else, we need to increase l2 and decrease r1, to do that we will shift low to cut1+1 position

### Code
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        if(m < n) {
            return ninjaAndLadoos(row2, row1, n, m, k);
        }

        int low = Math.max(0,k-n);
        int high = Math.min(k,m);

        while(low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : row1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : row2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : row1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : row2[cut2];
            
            //just checking these conditions as li<=r1 && l2<=r2 automatically
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return 0;
    }

### Other Techniques
- Use to sorting way we use in merge sort and extra space

### Complexity
1. Time Complexity - O(log (m+n))
2. Space Complexity - O(1)