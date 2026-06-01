class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        triangle.add(row);
        for(int i=0;i<numRows-1;i++){
            List<Integer> prev = triangle.get(triangle.size()-1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int j=0;j<prev.size()-1;j++){
                current.add(prev.get(j)+prev.get(j+1));
            }
            current.add(1);
            triangle.add(current);
        }
        return triangle;
    }
}