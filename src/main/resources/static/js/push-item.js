
var h1=document.getElementById("empty")
var toDoList=["Take the kids to the Park","Study JavaScript/DOM","Go Grocery Shopping","Clean the house"]
/////////////////////upload your to do list on loading the page/////////////////////////////////
document.addEventListener("load",loadToDoList())

function loadToDoList(){
  ///////*******************with loop*****************//////
  /*  for(let i=0;i<toDoList.length;i++)
    {
        item+="<li>"+toDoList[i]+"</li>\n"
    }*/

      ///////*******************with reduce function*****************//////
    item=toDoList.reduce((text,value)=> text+="<li>"+value+"</li>\n" ,"")
    document.getElementById("myList").innerHTML=item
    h1.innerHTML="My To_Do-List"
    

}

var list = document.getElementById('myList');
////////////////////// ********************add item to the to-do-list************************/
function pushItem(){

var inputText = document.getElementById('item').value;
var newItem = document.createElement('li');
if(inputText!=="")
{ h1.innerHTML="My To_Do-List"
 newItem.innerHTML=inputText;
 list.appendChild(newItem)
}
else
    alert("Enter A valid To-Do List Item")
document.getElementById('item').value="";

} 

////////////////////// ********************remove item from the to-do-list************************/
document.getElementById("myList").addEventListener('click', function (e) {
    var clickeTarget = e.target;
    if (clickeTarget && clickeTarget.nodeName === "LI")
    {   ////////////change li with style////////////
        clickeTarget.style.textDecoration="line-through";
        ////////////change li with changing the class assigned to it////////////
        clickeTarget.className="remove"
        alert("You are about to delete this To-Do-Item:\n" +e.target.innerHTML);
        setTimeout(() => {
            clickeTarget.remove();
            if(document.getElementById("myList").children.length==0)
                  h1.innerHTML="There is no item in your To-Do-List"
            else
               h1.innerHTML="My To_Do-List"
            //console.log(document.getElementById("myList").children.length)
         }, 1000);         
    }
  
})
  
   






