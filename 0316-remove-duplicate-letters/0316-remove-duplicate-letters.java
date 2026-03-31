class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];

        // count frequency
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;

            if(stack.contains(ch)) continue;

            while(!stack.isEmpty() &&
                  stack.peek() > ch &&
                  freq[stack.peek() - 'a'] > 0){
                stack.pop();
            }

            stack.push(ch);
        }

        StringBuilder result = new StringBuilder();
        for(char ch : stack){
            result.append(ch);
        }

        return result.toString();
    }
}