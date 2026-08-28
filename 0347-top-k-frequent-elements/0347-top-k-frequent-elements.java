class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int i=0 ;i<nums.length; i++){
           int key =nums[i];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        // List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        // Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // int freq[] = new int[k];
        // for(int i=0; i<k; i++){
        //     freq[i]= list.get(i).getKey();
        // }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int i=0; i<nums.length+1; i++){
            bucket[i]= new ArrayList();
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(key);
        }
        int [] result = new int[k];
        int index =0;
        for(int i = bucket.length-1; i>=0; i--){
                for(int num: bucket[i]){

                    result[index++] = num;
                    if(index == k){
                        return result;
                    }
                }
        }
        return result;
    }
}