//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        HashSet<Integer>[] graph = new HashSet[K];
        for(int i = 0; i < K; i ++) graph[i] = new HashSet<>();
        int[] ind = new int[K];
        for(int i = 0; i < N - 1; i ++) {
            int x = 0, y = 0;
            String a = dict[i], b = dict[i + 1];
            while(x < a.length() && y < b.length()) {
                char c1 = a.charAt(x), c2 = b.charAt(y);
                if(c1 != c2 ) {
                    graph[c1 - 'a'].add(c2 - 'a');
                    break;
                }
                x ++;
                y ++;
            }
        } 
        for(int i = 0; i < K; i ++) {
            for(int x : graph[i]) ind[x] ++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < K; i ++) {
            if(ind[i] == 0) que.add(i);
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()) {
            int out = que.remove();
            sb.append((char)('a' + out));
            for(int nbr : graph[out]) {
                if(--ind[nbr] == 0) que.add(nbr);
            }
        }
        return sb.toString();
    }
}