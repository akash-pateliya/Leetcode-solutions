class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start =0, end =0;
        int k = s1.length();
        int len = s2.length();
        
        for(int i=0; i<k; i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int size = map.size();
        
        while(end < len){
            char ch = s2.charAt(end);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    size--;
                }
            }
            
            if(k > (end - start + 1)){
                end++;
            }
            else if(k == (end - start + 1)){
                if(size == 0){
                    return true;
                }
                
                ch = s2.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) == 1){
                        size++;
                    }
                }
                
                start++;
                end++;
            }
        }
        
        return false;
    }
}