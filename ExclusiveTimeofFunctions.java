// Time Complexity : O(n + m) m is number of logs
// Space Complexity : O(n)
/*
 * traverse though the logs and for every log if it is the start
 * add the value to the existing in stack and append to result.
 * if it is the end pop the stack and then append it.
 */

 class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null) return new int[0];
        int[] result = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            String[] splitLog = log.split(":");
            int taskId = Integer.parseInt(splitLog[0]);
            int curr = Integer.parseInt(splitLog[2]);
            if(splitLog[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            }
            else{
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}