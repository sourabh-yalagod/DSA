class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num,map.getOrDefault(num,0)-1);
                if(map.get(num)<=0){
                    map.remove(num);
                }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}