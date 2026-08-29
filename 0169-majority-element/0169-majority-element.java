class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int c = nums[i];
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int n = nums.length/2;
        for(Map.Entry <Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }
        return -1;
    }
}