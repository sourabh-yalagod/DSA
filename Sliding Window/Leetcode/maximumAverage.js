var findMaxAverage = function(nums, k) {
    let sum=0;
    for(let i=0;i<k;i++){
        sum+=nums[i];
    }
    let start = 0;
    let end = k;
    let tempMax = sum;
    while(end<nums.length){
        tempMax -= nums[start++];
        tempMax += nums[end++];
        if(tempMax>sum){
            sum=tempMax
        }
    }
    
    return sum/k;
};
const array = [1,12,-5,-6,50,3];
const k = 4;
console.log(findMaxAverage(array,k));
