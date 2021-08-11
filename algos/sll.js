class Node{
    constructor(valueInput){
        this.value = valueInput;
        this.next = null;

        //new property!!!!
        this.child= null;
    }
}


class SLL{
    constructor(){
        this.head = null;
    }

    addToBack(valueInput){
        //CREATE A NEW NODE
        var nodeToAdd = new Node(valueInput);

        //make the node a part of the SLL
        if(this.head == null){
            this.head = nodeToAdd;
        }else{
            var runner = this.head;
            while(runner.next != null){//while the runner is not pointing to the last node
                //move runner to the next node until it gets to a node where the .next = null
                runner = runner.next;
            }
            runner.next = nodeToAdd;
        }

        return this
        
    }

    display(){
        var runner = this.head;
        var result = "";
        while(runner != null){
            result += runner.value + "--->"
            runner = runner.next
        }
        console.log(result);
    }

    removeFront(){
        if(this.head == null){
            console.log("nothing to remove fam. But how was your weekend? We can remove stress maybe....but we def can't remove a node if the SLL is empty")
        }else{
            this.head = this.head.next
        }
        return this
    }

    reverse(){
        let arr= [];
        let runner = this.head;
        while(runner!= null){
            arr.unshift(runner.value);
            runner = runner.next;
        }
        for(let i = 0; i<arr.length; i++){
            this.addToBack(arr[i]);
            this.removeFront()
        }

        return this

    }

    populateChildren(){
        let runner = this.head;

        while(runner !== null){
            let numChildren = Math.floor(Math.random() * 5);
            if(numChildren !== 0){
                let childList = new SLL();
                for(let i = 0; i < numChildren; ++i){
                    childList.addToBack(Math.floor(Math.random() * 50));
                }
                runner.child = childList;
            }
            runner = runner.next;
        }
    }

    printMeWithChildren(){
        let returnStr = '';
        let runner = this.head;
        while(runner != null){
            returnStr += `${runner.value}`;
            if(runner.child){
                returnStr += "(";
                let runner2 = runner.child.head;
                while(runner2 !== null){
                    returnStr += `${runner2.value} ->`;
                    runner2 = runner2.next;
                }
                returnStr += ")";
            }
            returnStr += " -> ";
            runner = runner.next;
        }
        console.log(returnStr);
        return returnStr;
    }


    flatten(){
        var runner = this.head;
        //i need to go from node to node, and each time in at a node, i need to check if it has a child---> for each node i need to do something
        while(runner != null){
            //check if the runner has a child
            if(runner.child != null){
                //get the last node in the child to point to the node that comes after runner--> run through each node in the child SLL until I get to the last node---> loop through the child sll until runner.next == null
                //in other words, as long as childRunner.next != null, i need to increment childRunner
                var childRunner = runner.child.head
                while(childRunner.next != null){
                    childRunner = childRunner.next
                }
                //after the while loop completes, the childRunner variable is pointing to the last node in the child SLL
                //the original runner.next is pointing to the next node in the parent sll. we want the last node in the child sll to point to the next node iin the parent sll
                childRunner.next = runner.next

                runner.next = runner.child.head
                runner.child = null;
                runner = runner.next;
            }
            else{
                runner = runner.next;
            }
        }

        return this;

    }

    flattenChildrenRec(){
        let parentrunner = this.head;
        let runner = this.head.next;
      
        while(runner != null){
          if(parentrunner.child === null){
            parentrunner = runner;
          }
          else{
            parentrunner.child.flattenChildrenRec();
            // ^^ adding this line is basically the only change
      
            parentrunner.next = parentrunner.child.head;
            parentrunner.child = null;
            while(parentrunner.next != null){
              parentrunner = parentrunner.next;
            }
            parentrunner.next = runner;
            parentrunner = runner;
          }
          runner = runner.next;
        }
        return this;
      }


}

var sll1 = new SLL();

sll1.addToBack(23).addToBack(15).addToBack(41).addToBack(1).display()


sll1.populateChildren()
sll1.printMeWithChildren()

console.log("**************")

sll1.flatten().printMeWithChildren()



//research the arr.unshift() method

