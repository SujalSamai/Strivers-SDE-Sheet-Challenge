package Arrays.PascalTriangle;

import java.util.ArrayList;

public class Code {
//    TC & SC - o(n^2)
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Long> temp= new ArrayList<>();
            if(i==0) temp.add(1L);
            else{
                for(int j=0; j<=i; j++){
                    if(j==0 || j==i){
                        temp.add(1L);
                    }else{
                        temp.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                    }
                }
            }
            list.add(temp);
        }
        return list;
    }
}
