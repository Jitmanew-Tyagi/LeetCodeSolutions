class Solution {
    public long maximumSumOfHeights(List<Integer> listOfHeights) {
        
        int a[]=new int[listOfHeights.size()];
        for(int i=0;i<listOfHeights.size();i++)a[i]=listOfHeights.get(i);
        long Total=0;

        for(int i=0;i<a.length;i++){
            long count=0;
            long max=a[i];
            for(int j=i;j>=0;j--){
                if(a[j]<=max){
                    max=a[j];
                    count+=max;
                }else count+=max;
            }
            max=a[i];
            for(int j=i+1;j<a.length;j++){
                    if(a[j]<=max){
                        max=a[j];
                        count+=max;
                    }else count+=max;
            }
                    
            Total=Math.max(Total,count);
        }

        return Total;
    }
}