var x = [3,6,1,2,8,3,2,6,0];



function removeDupes(arr){
    var obj = {};
    for(let i = 0; i<arr.length; i++){
        //if the object does not contain a key represnting the current number
        if(!obj[arr[i]]){
            //then we create a key with that number and give it a value
            obj[arr[i]] = "taken"
        }else{
            //else, if the object already has a key for that number, then we must remove the value at the current index
            // splice(start, deleteCount)
            arr.splice(i,1)
            i--
        }
    }
    return arr;
}

console.log(removeDupes(x))

// obj = {
//     3: "taken", 
//     6: "taken",
//     1: "taken",
//     2: "taken",
//     8: "taken",
//     0: "taken"
// }
//x = [3,6,1,2,8,0];




// let objexample = {1: "wazaa", 3: "oh okay den", hello: "hi tho"}

// if(objexample["hello"]){
//     console.log("key exists")
// }else{
//     console.log("who dat, key does not exist")
// }

// objexample["key3"] = "new value for a new key"

// console.log(objexample)




//beginner
//you can create a new array and push values from original into the new one


//medium
//you cannot create a new array, you have to do it in place. Nested for loops are allowed

//advanced
//you cannot create a new array, you have to do it in place. Nested for loops are NOT allowed --hint (rob used an object)

