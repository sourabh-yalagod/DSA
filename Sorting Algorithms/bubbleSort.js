const bubbleSort =(array)=>{
    for(let i=0;i<array.length-1;i++){
        let flag=false
        for(let j=0;j<array.length-i-1;j++){
            if(array[j]>array[j+1]){
                flag=true
                let temp = array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }
        }
        if(!flag) break
    }
    return array
}

const array=[12,34,56,45,87,67,-9,7]
console.log(bubbleSort(array));
