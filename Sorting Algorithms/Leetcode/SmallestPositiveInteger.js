var firstMissingPositive = function(array) {
    let index = 0;
    while(index<array.length){
        let currentValueIndex = array[index]-1;
        if(array[index] > 0 &&
            array[index] <= array.length &&
            array[index] !== array[correctIndex]){
            let temp = array[currentValueIndex];
            array[currentValueIndex] = array[index];
            array[index] = temp;
        }else{
            index++;
        }
    }
    for(index=0;index<array.length;index++){
        if(array[index]!=(index+1)){
            return index+1
        }
    }
    return index+1
};
const array = [7,8,9,11,12]
console.log(firstMissingPositive(array));
