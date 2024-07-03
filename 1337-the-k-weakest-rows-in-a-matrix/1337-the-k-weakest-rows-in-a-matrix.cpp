class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<int>ans;
        priority_queue<pair<int, int>> maxheap;
        for(int i=0;i<mat.size();i++) {
            int sum=0;
            for(int j=0;j<mat[0].size();j++) {
                sum+=mat[i][j];
            }
            maxheap.push({sum,i});
            if(maxheap.size()>k) {
                maxheap.pop();
            }
        }
        while(!maxheap.empty())
        {
            ans.push_back(maxheap.top().second);
            maxheap.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};