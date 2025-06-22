function find(array,target){
    let low = 0;
    let high = array.length-1;
    while(low<high){
        let mid = Math.floor((high+low)/2)
        if(array[mid]>array[mid+1]){
            return mid
        }
        if(array[mid-1]>array[mid]){
            return mid-1
        }
        if(array[low]<array[mid]){
            low=mid+1
        }else{
            high=mid;
        }
    }
    return low;
} 
console.log(find([78,89,100,121,1],100));