const missingNumber=(array)=>{
    let index=0;
    let ans=-1
    while(index<array.length){
        let current=array[index]
        if(current==index){
            index++;
        }else{
            let temp = array[index];
            array[index]=array[current]; 
            array[current]=temp;
            index++
        }
    }
    for(let i=0;i<array.length;i++){
        if(array[i]==undefined) return i
    }
}

const array=[0,1,3]
console.log(missingNumber(array));
