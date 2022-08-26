class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        
        for(String str: wordList){
            set.add(str);
        }
        
        if(!set.contains(endWord)){
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int ans=0;
        int len = beginWord.length();
        while(!queue.isEmpty()){
            
            int size = queue.size();
            ans++;
            for(int k=0; k<size; k++){
                String top = queue.remove();
                StringBuilder sb = new StringBuilder(top);
            
                for(int i=0; i<len; i++){
                    char ch = sb.charAt(i);
                    for(char j='a'; j<='z'; j++){
                        sb.setCharAt(i, j);
                        String tempStr = sb.toString();
                        if(tempStr.equals(endWord)){
                            return ans + 1;
                        }
                        
                        if(set.contains(tempStr)){
                            queue.add(tempStr);
                            set.remove(tempStr);
                        }
                    }
                    sb.setCharAt(i, ch);
                }
            }
                
        }
        
        return 0;
    }
}