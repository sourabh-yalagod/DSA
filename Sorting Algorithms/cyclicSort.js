const cyclicSort =(array)=>{
    let i=0;
    while(i<array.length){
        if(array[i]==i+1){
            i++;
        }else{
            let temp=array[array[i]-1];
            array[array[i]-1]=array[i];
            array[i]=temp;
        }
    }
    return array
}

const array=[1,5,4,3,2,7,6,8,10,9,11]
console.log(cyclicSort(array));
