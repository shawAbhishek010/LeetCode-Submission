class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phone_map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };//index = 0+2
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[digits.length()];
        int index = 0;
        for (char ch : digits.toCharArray()) {
            int dgt = ch - '0';
            arr[index++] = dgt;
        }
        helper(0, arr, phone_map, ans, sb);
        return ans;
    }

    public void helper(int idx, int arr[], String[] phone_map, List<String> ans, StringBuilder sb) {
        //base condn
        if (idx == arr.length) {
            ans.add(sb.toString());
            return;
        }
        String req = phone_map[arr[idx] - 2];
        for (int i = 0; i < req.length(); i++) {
            sb.append(req.charAt(i));
            helper(idx + 1, arr, phone_map, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
