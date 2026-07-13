// class Solution {
//     public List<Integer> sequentialDigits(int low, int high) {
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 1; i < 9; i++) {
//             q.add(i);
//         }
//         List<Integer> ans = new ArrayList<>();
//         while (q.size() != 0) {
//             int pop = q.remove();
//             if (pop >= low && pop <= high) {
//                 ans.add(pop);
//             }
//             int lastDigit = pop % 10;
//             if (lastDigit < 9) {
//                 int addValue = pop * 10 + (lastDigit + 1);
//                 if (addValue <= high)
//                     q.add(addValue);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String min = String.valueOf(low);
        int n = min.length();
        String max = String.valueOf(high);
        int m = max.length();
        String num = "123456789";
        for (int len = n; len <= m; len++) {
            for (int i = 0; i + len <= 9; i++) {
                String s = num.substring(i, i + len);
                int val = Integer.parseInt(s);

                if (val >= low && val <= high) {
                    list.add(val);
                }
            }
        }

        return list;
    }
}