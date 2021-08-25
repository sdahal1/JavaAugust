class TrieNode{
    constructor(letter){
        this.letter = letter;
        this.children = {};
        this.isWord = false;
    }
}


class TrieSet{
    constructor(){
        this.root = new TrieNode("");
    }

    add(str){
        //we need a way to go through the trieset (runner will rep the node we are currently on as we traverse down the trieset)
        let runner = this.root;

        //we need to insert each letter from the input into the trieset (want to create a trieNode FOR each letter from the input)
        //FOR*** EACH*** hint hint LETTER we need to do something
        for(let i = 0; i<str.length; i++){
            // console.log(runner.children)
            // console.log("each letter from the input is represented by--->",str[i] )
            //if the runner.children does not contain a key representing a letter from the input, then create a trienode containing a letter from the input and make it a child of the current node (runner)
            if(!runner.children.hasOwnProperty(str[i])){
                //create a trie node containing a letter from the input
                // let newNode = new TrieNode(str[i])
                //set the current node (runner)'s children to have that new key representing that new trieNode
                runner.children[str[i]] = new TrieNode(str[i])
            }
            //move runner to the next node
            runner = runner.children[str[i]]
        }
        //by the time the for loop finishes, we have inserted all the letters from the input into the trieset, and we can mark that last letter as the ending of a word
        runner.isWord = true;

    }

    printAllWords(node, str){
        //base case
        if(node.isWord == true){
            console.log(str)
        }
        //forward progress recursive case
        for(const key in node.children){
            this.printAllWords(node.children[key], str+key );
        }

    }

    contains(str){
        //need something to traverse the TrieSet with -> runner
        let runner = this.root;

        //FOR each letter from the input i want to check if the trieset has a node for it
        for(let i = 0; i< str.length && runner != null; i++){
            //check if str[i] (current letter) is a children of the runner
            if(runner.children[str[i]] == null){
                return false
            }else{
                runner = runner.children[str[i]]
            }
        }

        //check if the node that the runner ends up at is registered as a word. if it is, return true, if not, return false
        if(runner.isWord){
            return true;
        }else{
            return false;
        }
    }


}



//this.printAllWords(node.children[a], "a" );
    //this.printAllWords(node.children[p], "ap" );
        //this.printAllWords(node.children[e], "ape" );
            //console.log("ape")
        //this.printAllWords(node.children[p], "app" );
            //this.printAllWords(node.children[l], "appl" );
                //this.printAllWords(node.children[e], "apple" );
                    //console.log("apple")

//this.printAllWords(node.children[d], "d" );
//this.printAllWords(node.children[c], "c" );





var setOfWords = new TrieSet();

setOfWords.add("ape");
setOfWords.add("apple");
setOfWords.add("dog");
setOfWords.add("cat");
setOfWords.add("pie")

setOfWords.printAllWords(setOfWords.root, "");

// setOfWords.add("are");
console.log(setOfWords.contains("ape")) //true
console.log(setOfWords.contains("apeee")) //false
console.log(setOfWords.contains("appl")) //false
console.log(setOfWords.contains("potato")) //false





//roots children right now looks like this: 
// let x = {
//     a: new TrieNode("a"),
//     d: new TrieNode("d"),
//     c: new TrieNode("c")
// }


//childrren for the trienode conaining "c" --> {"a": new TrieNode("a")}

//children for the trienode containint "a" --> {"t": new TrieNode('t')}






