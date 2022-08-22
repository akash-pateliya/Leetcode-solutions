class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int start =0, end=0;
        int count=0;
        
        while(end < s.length()){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.size() == 3){
                ch = s.charAt(start);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
                start++;
            }
            count = count + start;
            end++;
        }
        
        return count;
    }
}