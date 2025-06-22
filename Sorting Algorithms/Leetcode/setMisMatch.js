var findErrorNums = function(array) {
    let index=0;
    while(index<array.length){
        const currentValueIndex = array[index]-1;
        if(array[index]!=(index+1)){
            if(array[index] == array[currentValueIndex]){
                return [array[index],currentValueIndex]
                index++;
                continue;
            }
            let temp = array[index];
            array[index] = array[currentValueIndex];
            array[currentValueIndex] = temp;
        }else{
            index++;
        }
    }
    console.log(array);
    
    for(index=0;index<array.length;index++){
        if(array[index]!=(index+1)){
            return [array[index],index+1]
        }
    }
    return [-1,-1]
};

const array = [8,7,3,5,3,6,1,4];
console.log(findErrorNums(array));
