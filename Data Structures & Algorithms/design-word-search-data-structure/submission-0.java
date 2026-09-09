class TrieNode { 
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean end = false;
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int j, TrieNode root){
        TrieNode curr = root;
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : curr.children.values()){
                    if(child != null && dfs(word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(!curr.children.containsKey(c)){
                    return false;
                }
                curr = curr.children.get(c);
            }
        }
        return curr.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */