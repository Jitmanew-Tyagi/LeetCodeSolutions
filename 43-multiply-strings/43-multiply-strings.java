class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String ans = "0";
        int x = num1.length(), y = num2.length(), mul = 1;
        for(int i = y - 1; i >= 0; i --) {
            String res = multiply(num1, num2.charAt(i) - '0');
            for(int m = 1; m < mul; m ++) res += "0";
            mul += 1;
            ans = addStrings(ans, res);
        }
        return ans;
    }
    
    public String multiply(String num1, int x) {
        int i = num1.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i > -1) {
            int sum = (num1.charAt(i --) - '0') * x + carry;
            sb.insert(0, sum % 10 + "");
            carry = sum / 10;
        }
        if(carry > 0) sb.insert(0, carry);
        int il = 0;
        String an = sb.toString();
        while(il < an.length() && an.charAt(il) == '0') il ++;
        return il == an.length() ? "0" : an.substring(il);
    }
    
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i > -1 && j > -1) {
            int sum = num1.charAt(i --) - '0' + num2.charAt(j --) - '0' + carry;
            sb.insert(0, sum % 10 + "");
            carry = sum / 10;
        }
        while(i > -1) {
            int sum = num1.charAt(i --) - '0' + carry;
            sb.insert(0, "" + sum % 10);
            carry = sum / 10;
        }
        while(j > -1) {
            int sum = num2.charAt(j --) - '0' + carry;
            sb.insert(0, "" + sum % 10);
            carry = sum / 10;
        }
        if(carry > 0) sb.insert(0, carry+  "");
        return sb.toString();
    }
}