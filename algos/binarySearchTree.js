class Node{
    constructor(valueInput){
        this.value = valueInput;
        this.left = null;
        this.right = null;
    }
}

class BST{
    constructor(){
        this.root = null;
    }

    add(valueInput){
        let newNode = new Node(valueInput);
        //logic to determine where to place this node in the BST
        if(this.root== null){
            this.root = newNode
        }else{
            let squirrel = this.root;
            while(squirrel != null){
                //go to the right
                if(valueInput > squirrel.value){
                    if(squirrel.right == null){//if the position to the right is open for the new node to be placed in
                        squirrel.right = newNode;
                        return this;
                    }
                    else{
                        squirrel= squirrel.right;
                    }
                   
                }else if(valueInput < squirrel.value){
                    //go to the left
                    if(squirrel.left == null){
                        squirrel.left = newNode;
                        return this;
                    }
                    else{
                        squirrel= squirrel.left;
                    }
                }else{
                    //no duplicates allowed
                    console.log("no duplicates allowed")
                    return this;
                }
            }

        }

        return this;
    }

    printTree(node){
        console.log("Current node = ", node.value);
        if(node.left!=null){
            console.log("left node of", node.value, "= " + node.left.value)
            this.printTree(node.left)
        }
        if(node.right != null){
            console.log("Right node of", node.value, " = " + node.right.value)
            this.printTree(node.right);
        }
    }

    findMax(){
        let koalabear = this.root;
        while(koalabear.right != null){
            koalabear = koalabear.right;
        }
        return koalabear.value;
    }

    findMin(){
        let koalabear = this.root;
        while(koalabear.left != null){
            koalabear = koalabear.left;
        }
        return koalabear.value;
    }

    findMinRecursive(node){
        var runner = node;
        if(runner.left != null){
            return this.findMinRecursive(runner.left)
        }else{
            console.log(runner.value)
            return runner.value;
        }
    }
    findMaxRecursive(node){
        var runner = node;
        if(runner.right != null){
            return this.findMaxRecursive(runner.right)
        }else{
            console.log(runner.value)
            return runner.value;
        }
    }

    size(node){
        //base case
        if(node == null){
            return 0;
        }
        //recursive case
        else{
            return (this.size(node.left) + 1 + this.size(node.right))
        }
    }

    contains(valueToFind){
        let current = this.root;
        while(current!= null){
            if(current.value == valueToFind){
                return true;
            }
            else if(valueToFind< current.value){
                current = current.left
            }else{
                current = current.right
            }
        }
        return false;

    }

    recursiveContains(valueToFind, node){
        //base case- if the node is null, then it wont contain anything
        if(node== null){
            return false
        }
        //base case - if the node input's value is equal to the value to find
        if(node.value == valueToFind){
            return true
        }//recursive case--> where the function calls itself, but when it calls itself, it give is a new input that takes us one step closer to the base case
        else if(valueToFind< node.value){
            return this.recursiveContains(valueToFind, node.left)
        }else{
            return this.recursiveContains(valueToFind, node.right)
        }

    }


    height(node){

    }
//recursiveContains(12, node(23))
    //recursiveContains(12, node(15))
        //recursiveContains(12, node(12))
            //true





}

//this.size(node(23))--> returns--> 2 + 1 + 2
    //this.size(node(15)) --> returns --> 1 + 1 + 0
        //this.size(node(12))--> returns-> 0 + 1 + 0

    //this.size(node(28))-> returns-->1 + 1 + 0
        //this.size(node(27))--> returns --> 0 + 1 + 0



let bst1 = new BST();

bst1.add(23).add(15).add(12).add(28).add(27).add(1)
bst1.printTree(bst1.root)
// console.log(bst1.findMin())
bst1.findMinRecursive(bst1.root)
bst1.findMaxRecursive(bst1.root)

console.log(bst1.size(bst1.root))
bst1.height(bst1.root);



// console.log(bst1.contains(15, bst1.root)) //true
// console.log(bst1.contains(28, bst1.root)) //true
// console.log(bst1.contains(23)) //true
// console.log(bst1.contains(12)) //true
// console.log(bst1.contains(13)) //false


console.log(bst1.recursiveContains(12, bst1.root)) //true
console.log(bst1.recursiveContains(27, bst1.root)) //true
console.log(bst1.recursiveContains(3, bst1.root)) //false




