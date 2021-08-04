//helpful hint: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/slice


var x = [-8, 2, 5, 12, 14, 17, 21, 23, 32, 100, 122, 145, 164];
//[-8, 2, 5, 12, 14, 17]
//[-8, 2, 5]
//[2,5]





//iterative approach, this is NOT binary search approach
// function findValueInArray(valueToFind, arr){
//     for(let i = 0; i< arr.length; i++){
//         if(arr[i] == 13){
//             return true
//         }
//     }
//     return false

// }

// findValueInArray(13, x) //false
// findValueInArray(122, x) //true



//binary search solution starts here ********************

function binarySearch(arr,target){
    //base case
    if(arr.length ==1){
        return arr[0] == target;
    }
    //find the midpoint in the array
    var mid = Math.floor(arr.length/2)

    if(target == arr[mid]){
        return true
    }else if(target < arr[mid]){ //this means i want the left half of the array to check next
        // arr.slice(0,mid)
        return binarySearch(arr.slice(0,mid), target)
    }else{ //if the target is greater than the value in the middle, this means that i wnat to get the right half of the array to check next
        return binarySearch(arr.slice(mid, arr.length), target)
    }


}


console.log(binarySearch(x, 5))//true
console.log(binarySearch(x, 56))//false


