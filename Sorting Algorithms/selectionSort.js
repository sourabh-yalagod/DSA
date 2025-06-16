const selectionSort = (array) =>{
    for(let i=0;i<array.length-1;i++){
        let min = i;
        for(let j=i;j<array.length;j++){
            if(array[j]<array[min]){
                min=j;
            }
        }
        if(min!=i){
            let temp = array[min]
            array[min]=array[i];
            array[i]=temp
        }
    }
    return array
}

const array = [12,324,45,5,-9,78]
console.log(selectionSort(array));
