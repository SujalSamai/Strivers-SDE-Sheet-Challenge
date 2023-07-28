### Question
- Given two version numbers, version1 and version2, compare them. 
- Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers. 
- To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1. 
- Return the following:
  - If version1 < version2, return -1. 
  - If version1 > version2, return 1. 
  - Otherwise, return 0.

### Sample Input
    version1 = "1.01", version2 = "1.001"
    version1 = "1.0", version2 = "1.0.0"
    version1 = "0.1", version2 = "1.1"

### Sample Output
    0
    0
    -1


### Solution
- We will try to get the number before and after dots for each version
- First we will convert the string of version 1 for each of its parts (separated by colon) to a number & also convert the string of version 2 for each of its parts
- we will compare part by part number of each version & return answer accordingly

### Code
    public static int compareVersion(String version1, String version2){
        int i=0, j=0;
        while (i< version1.length() || j< version2.length()){
            int temp1=0;
            int temp2=0;
            while (i < version1.length() && version1.charAt(i)!='.'){
                temp1= temp1*10 + version1.charAt(i)-'0';
                i++;
            }
            while (j < version2.length() && version2.charAt(j)!='.'){
                temp2= temp2*10 + version2.charAt(j)-'0';
                j++;
            }

            if (temp1>temp2) return 1;
            else if (temp1<temp2) return -1;
            else {
                i++;
                j++;
            }
        }
        return 0;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)