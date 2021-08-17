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
}


let bst1 = new BST();

bst1.add(23).add(15).add(12).add(28).add(27)
bst1.printTree(bst1.root)
// console.log(bst1.findMin())
bst1.findMinRecursive(bst1.root)
bst1.findMaxRecursive(bst1.root)

