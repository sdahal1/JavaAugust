class Node{
    constructor(valueInput){
        this.value = valueInput;
        this.next = null;
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


}

var sll1 = new SLL();

sll1.addToBack(23).addToBack(15).addToBack(41).addToBack(1).display()

sll1.reverse().display()



//research the arr.unshift() method

