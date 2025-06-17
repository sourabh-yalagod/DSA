const twoSum = (array,target) => {
    const targetMap = new Map();
    for(let index=0;index<array.length;index++){
        let targetElement = target - array[index];
        console.log(targetElement,targetMap);
        
        if(targetMap.has(targetElement)){
            return [targetMap.get(targetElement),index];
        }else{
            targetMap.set(array[index],index);
        }   
    }
    return [-1,-1];
}

console.log(twoSum([2,7,11,15],9));
