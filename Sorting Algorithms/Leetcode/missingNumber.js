const missingNumber=(array)=>{
    let index=0;
    while(index<array.length){
        let currentValueIndex = array[index]; 
        if(currentValueIndex<array.length && currentValueIndex!=index){
            let temp = array[index];
            array[index] = array[currentValueIndex];
            array[currentValueIndex]=temp;
        }else{
            index++;
        }
    }
    for(index=0;index<array.length;index++){
        if(array[index]!=index){
            return index;
        }
    }
    return -1;
}
const nums = [9,6,4,2,3,5,7,0,1]

;
console.log("Number : ",missingNumber(nums));
