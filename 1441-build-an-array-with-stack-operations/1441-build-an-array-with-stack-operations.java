class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currentIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (currentIndex >= target.length) {
                // We've processed all elements in the target array
                break;
            }

            if (target[currentIndex] == i) {
                // Current element matches the target
                operations.add("Push");
                currentIndex++;
            } else {
                // Current element does not match the target
                operations.add("Push");
                operations.add("Pop");
            }
        }

        return operations;
    }
}