let arr1= [4,5,2,-8,6] //false

let arr2 = [1,2,3,4,10] //true

//gona need 2 variables, one to keep track of sum on leftscale and sum on rightscale

//needs some looping to go through array and update running sum for leftside vs rightside--> each time we compare the left vs right to see if they are equal


function balancePoint(arr){
    var runSum = 0;
    for(var i = 0; i< arr.length; i++){
        runSum+=arr[i]
        var tailSum = 0;
        for(let x =arr.length-1; x>i; x--){
            tailSum+=arr[x]
        }
        if(runSum ==tailSum){
            return true
        }
    }
    return false
}



console.log(balancePoint(arr1)) //false

console.log(balancePoint(arr2)) //true




function balancePoint3(arr){
    var total = 0;
    var sumleft = 0;
    for(var i = 0; i< arr.length; i++){
        total += arr[i]
    }
    for(var i = 0; i< arr.length; i++){
        sumleft += arr[i];
        total -= arr[i];
        if(sumleft ==total){
            return true
        }
    }
    return false
}

console.log(balancePoint3(arr2)) //true
