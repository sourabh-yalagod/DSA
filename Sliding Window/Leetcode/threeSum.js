var threeSum = function(nums) {
    const result=[]
    const array=nums.sort((a,b)=>a-b)
    let sum=0;
    console.log("array",array);
    
    let start = 1;
    let end = start+3;
    for(let i=start;i<array.length;i++){
        console.log(array.slice(start-1,end-1));
        
        sum-=array[start++];
        sum+=array[end++];
        if(sum==0){
            result.push(array.slice(start-1,end-1));
        }
    }
    return result;
}
const array=[-1,0,1,2,-1,-4]
console.log(threeSum(array));
