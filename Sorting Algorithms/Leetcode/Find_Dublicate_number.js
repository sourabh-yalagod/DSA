const findDuplicate = (array) => {
    let index = 0;
    const ans=[];
    while(index<array.length){
        let currentValueIndex = array[index]-1;
        if(array[index]!=(index+1)){
            if(array[index] == array[currentValueIndex]){
                index++;
                continue;
            }
            let temp = array[index];
            array[index] = array[currentValueIndex];
            array[currentValueIndex]=temp;
        }else{
            index++;
        }
    }    
    for(index=0;index<array.length;index++){
        if(array[index]!=(index+1)){
            ans.push(array[index])
        }
    }
    return ans;
}
const array = [1,1,2]
console.log(findDuplicate(array));
