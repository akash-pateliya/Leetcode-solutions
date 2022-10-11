class Solution {
    class Pair{
        char ch;
        int freq;
        
        Pair(char c, int f){
            this.ch = c;
            this.freq = f;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.freq - a.freq;
            }
        });
        
        for(char key: map.keySet()){
            maxHeap.add(new Pair(key, map.get(key)));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            Pair top = maxHeap.remove();
            char ch = top.ch;
            int freq = top.freq;
            
            while(freq > 0){
                sb.append(ch);
                freq--;
            }
        }
        
        return sb.toString();
    }
}