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

    autoComplete(str){
        //find if the sequence of the inputstring is even present in our trieset
        let runner = this.root;
        //purpose of this forloop is to get us into the last letter of the input string in our trieset to see what words exist from that point forward
        for(let i = 0; i< str.length; i++){
            //if the current node's children ccontains the letter from the autocomplete input string
            if(!runner.children.hasOwnProperty(str[i])){
                return [];
            }
            //if the key does exist, move runner to that node containing that letter
            runner = runner.children[str[i]]
        }

        const helperFunction = (node, newStr, arr)=>{
            //base case
            if(node.isWord){
                arr.push(newStr);
            }
            //recursive case with forward progress
            for(let key in node.children){
                arr = helperFunction(node.children[key], newStr+key, arr);
            }
            return arr;
        }

        return helperFunction(runner, str, [])
        
    }



}



//setOfWords.autoComplete("ap")
    //helperFunction(runner(p), "ap", [])
        //arr = helperFunction(node.children[e], "ape", []); --> ["ape"]

        //arr = helperFunction(node.children[p], "app", ["ape"]);
            //1st iteration->arr = helperFunction(node.children["l"], "appl", ["ape"]);
                //arr = helperFunction(node.children["e"], "apple", ["ape"]); --> ["ape", "apple"]
                //arr = helperFunction(node.children["i"], "appli", ["ape", "apple"]);
                    //arr = helperFunction(node.children["c"], "applic", ["ape", "apple"]);
                        //arr = helperFunction(node.children["a"], "applica", ["ape", "apple"]);
                            //arr = helperFunction(node.children["t"], "applicat", ["ape", "apple"]);
                                //arr = helperFunction(node.children["i"], "applicati", ["ape", "apple"]);
                                    //arr = helperFunction(node.children["o"], "applicatio", ["ape", "apple"]);
                                        ////arr = helperFunction(node.children["n"], "application", ["ape", "apple"]); --> ["ape", "apple", "application"]
            //2nd iteration->arr = helperFunction(node.children["e"], "appe", ["ape", "apple", "application"]);
                //["ape", "apple", "application", "appearance"]





var setOfWords = new TrieSet();

setOfWords.add("ape");
setOfWords.add("apple");
setOfWords.add("application");
setOfWords.add("appearance");
setOfWords.add("dog");
setOfWords.add("cat");

console.log(setOfWords.autoComplete("ap")) //["ape", "apple", "application", "appearance"]
console.log(setOfWords.autoComplete("app")) //["apple", "appearance", "application"]
console.log(setOfWords.autoComplete("po")) //[]

// setOfWords.printAllWords(setOfWords.root, "");

// // setOfWords.add("are");
// console.log(setOfWords.contains("ape")) //true
// console.log(setOfWords.contains("apeee")) //false
// console.log(setOfWords.contains("appl")) //false
// console.log(setOfWords.contains("potato")) //false





//roots children right now looks like this: 
// let x = {
//     a: new TrieNode("a"),
//     d: new TrieNode("d"),
//     c: new TrieNode("c")
// }


//childrren for the trienode conaining "c" --> {"a": new TrieNode("a")}

//children for the trienode containint "a" --> {"t": new TrieNode('t')}






