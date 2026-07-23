class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        int zeroBlockCount = 0;
        int oneCount = 0;
        int  i= 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroBlockCount++;
            } else {
                oneCount++;
                // Add only an actual zero block
                if (zeroBlockCount > 0) {
                    arr.add(zeroBlockCount);
                    zeroBlockCount = 0;
                }
            }
        }
        if (zeroBlockCount > 0) {
            arr.add(zeroBlockCount);
        }
        int maxSum = 0;

        for ( i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);
                maxSum = Math.max(maxSum, sum);
        }

        return maxSum + oneCount;
    }
}