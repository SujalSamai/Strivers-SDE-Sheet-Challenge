package Strings.CompareVersion;

public class Code {
    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";
        System.out.println(compareVersion(version1, version2));
    }
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
}
