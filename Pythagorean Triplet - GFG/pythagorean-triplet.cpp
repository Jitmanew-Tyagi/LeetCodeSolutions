// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

 // } Driver Code Ends
//User function template for C++
class Solution{
public:
	// Function to check if the
	// Pythagorean triplet exists or not
	
    bool checkTriplet(int arr[], int n) {
        // code here
        for (int i=0; i<n; i++){
            arr[i] *= arr[i];
        }
        sort(arr, arr+n);
        int high=0, low=0;
        for(int i=n-1; i>=0; i--){
            high = i-1;
            low = 0;
            int temp = arr[i];
            while (low < high){
                int a1 = arr[low], a2 = arr[high];
                if ((temp - (a1 + a2)) == 0){
                    return true;
                }else if ((temp - (a1 + a2)) > 0){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return false;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.checkTriplet(arr, n);
        if (ans) {
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }
    return 0;
}
  // } Driver Code Ends