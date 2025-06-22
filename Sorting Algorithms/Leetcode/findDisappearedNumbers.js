const findDisappearedNumbers=(array)=>{
    const ans = []
    let index = 0;
    while(index<array.length){
        let currentValueIndex = array[index]-1;
        if(array[index]!=(index+1)){
            let temp = array[index];
            array[index] = array[currentValueIndex];
            array[currentValueIndex]=temp;
            if(array[index] == array[currentValueIndex]){
                index++;
            }
            
        }else{
            index++;
        }
    }
    for(index=0;index<array.length;index++){
        if(array[index]!=(index+1)){
            ans.push(index+1)
        }
    }
    return ans;
}
const array = [4,3,2,7,8,2,3,1]
console.log(findDisappearedNumbers(array));
