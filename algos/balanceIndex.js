let arr1 = [1,2,3,4,3,10] //return 4

let arr2 = [3,4,7,2,9] //return -1 (no balancing index found)
let arr3 = [3,4,7,2,-2,9,14] //return 5


//balance index, return the index number where the balance happens

function balanceIndex(arr){
    let total = arr.reduce((a,b)=>a+b);
    let sumleft = 0;
    for(let i =0; i<arr.length; i++){
        total = total- arr[i]
        console.log("total and sum left are these:", total, sumleft)
        if(total == sumleft){
            return i;
        }
        sumleft += arr[i]
    }
    return -1

}

console.log(balanceIndex(arr1))

//arr= [1,2,3,4,3,10]
//total = 23->22->17->13->10
//sumleft = 0->1->3->6->10
//i = 0->1->2->3->4