// Matrix Search
// Jenny digs image and wants to make a JavaScript imaging library like PIL for python. She is given 2 different two-dimensional arrays, containing integers between 0 and 65535. Each two dimensional array represents a grey-scale image, where each integer value is a pixel. The second image might be somewhere inside the larger one. Return whether it is.
// Given Array: [ [12, 34, 45, 56],    And Array: [ [67, 78],      return: true
//                [98, 87, 76, 65],                 [43, 32] ];   
//                [56, 67, 78, 89],
//                [54, 43, 32, 21] ];



var bigarray = [
    [12, 34, 45, 56],
    [98, 87, 76, 65],
    [56, 67, 78, 89],
    [54, 43, 32, 21]
]

var smallarray = [
    [67, 78],
    [43, 32]
]

var smallarray2 = [
    [45, 56],
    [43, 65]
]


bigarray[2][1] == smallarray[0][0]

function matrixSearch(bigarr, smallarr){
    for(let i = 0; i < bigarr.length; i++) {
        for (let j = 0; j < bigarr[i].length; j++) {

            // if a value in bigarr equals the first value in small arr
            if(bigarr[i][j] == smallarr[0][0]){

                // compare values according to their positions
                if(smallarr[0][1] == bigarr[i][j+1] && smallarr[1][0] == bigarr[i+1][j] && smallarr[1][1] == bigarr[i+1][j+1]){
                    return true;
                }
            }
        }
    }
    return false;
}

matrixSearch(bigarray, smallarray) //true
matrixSearch(bigarray, smallarray2) //true

