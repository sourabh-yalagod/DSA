const insertionSort = (array) =>{
    for(let i=1;i<array.length;i++){
        let j=i-1;
        let key = array[i];
        while(j>=0 && array[j]>key){
            array[j+1]=array[j];
            j--;
        }
        array[j+1]=key;

    }
    return array
}

const array = [12,324,45,5,-9,78] 
console.log(insertionSort(array));
