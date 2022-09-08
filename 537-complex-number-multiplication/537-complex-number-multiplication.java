class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String n1[] = num1.split("\\+"), n2[] = num2.split("\\+");
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(n1[0]), b = Integer.parseInt(n2[0]);
        int c = Integer.parseInt(n1[1].substring(0, n1[1].length() - 1));
        int d = Integer.parseInt(n2[1].substring(0, n2[1].length() - 1));
        return((a * b) - (c * d)) + "+" + ((a * d) + (b * c)) + "i";
    }
}