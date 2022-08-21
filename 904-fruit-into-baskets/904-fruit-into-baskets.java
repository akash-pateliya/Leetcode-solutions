class Solution {
    public int totalFruit(int[] fruits) {
        
        if(fruits.length <= 2){
            return fruits.length;
        }
        
        HashMap<Integer, Integer> map =  new HashMap<>();
        int start =0, end =0;
        int max_win = Integer.MIN_VALUE;
        
        while(end < fruits.length){
            int fruitType = fruits[end];
            map.put(fruitType, map.getOrDefault(fruitType, 0) + 1);
            
            if(map.size() <= 2){
                max_win = Math.max(max_win, (end - start + 1));
            }
            else if(map.size() > 2){
                while(map.size() > 2){
                    fruitType = fruits[start];
                    map.put(fruitType, map.get(fruitType) - 1);
                    if(map.get(fruitType) == 0){
                        map.remove(fruitType);
                    }
                    start++;
                }
            }
            
            end++;
        }
        return max_win;
    }
}