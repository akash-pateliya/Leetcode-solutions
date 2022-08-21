class Solution {
    public int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int len = str.length();
        int ans = 0;
        while(end < len){
            char ch = str.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if(map.size() == (end - start + 1)){
                ans = Math.max(ans, (end - start + 1));
            }
            else{
                while(map.size() < (end - start + 1)){ // condition change here
                    ch = str.charAt(start);
                    map.put(ch, map.get(ch) - 1);
                    if(map.get(ch) == 0){
                        map.remove(ch);
                    }
                    start++;
                }
            }
            end++;
        }
        
        return ans;
    }
}