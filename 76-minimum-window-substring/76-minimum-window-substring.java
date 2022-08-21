class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int k = t.length();
        for(int i=0; i<k;i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int start =0, end=0;
        int len = s.length();
        int size = map.size();
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(end < len){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    size--;
                }
            }
            while(size == 0){
                ch = s.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) == 1){
                        size++;
                    }
                }
                if((end - start + 1) < min){
                    min = (end - start + 1);
                    i = start;
                    j = end;
                }
                start++;
            }
            
            end++;
        }
        if(min == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(i, j+1);
    }
}