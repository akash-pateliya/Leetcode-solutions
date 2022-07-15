// { Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}// } Driver Code Ends


/*You are required to complete this method */
class GfG
{
    static class Trie{
        Trie[] links;
        
        Trie(){
            this.links = new Trie[26];
        }
        
        boolean containsChar(char ch){
            return links[ch - 'a'] != null;
        }
        
        void insert(char ch, Trie node){
            links[ch - 'a'] = node;
        }
        
        Trie get(char ch){
            return links[ch - 'a'];
        }
    }
   public static int countDistinctSubstring(String str)
   {
       Trie root =  new Trie();
       int len = str.length();
       int ans = 0;
       for(int i=0; i<len; i++){
           Trie node = root;
           for(int j=i; j<len; j++){
               char ch = str.charAt(j);
               if(!node.containsChar(ch)){
                   node.insert(ch, new Trie());
                   ans++;
               }
               node = node.get(ch);
           }
       }
       return ans + 1;
   }
}