class Solution {
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