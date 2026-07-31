class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        int push = 0;
        Arrays.sort(freq);
        int index = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                break;
            int cost = index / 8 + 1;
            push += freq[i] * cost;
            index++;
        }
        return push;
    }
}