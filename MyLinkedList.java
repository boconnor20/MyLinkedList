public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   /*create a constructor*/
   size = 0;
   start = new Node(null);
   end = new Node(null);
 }
 public int size(){
   return size;
 }
 public boolean add(String value){
   Node  newNode=new Node(value);
   newNode.setNext(null);
   Node current=start;
   while(current.getNext() != null){
     current = current.getNext();
   }
   current.setNext(newNode);
   size++;
   return true;

 }
 public boolean add(int index, String value){
   Node newNode = new Node(value);
   Node current = start;
   if(current != null){
    for(int i = 0; i < index && current.getNext() != null; i++){
      current = current.getNext();
    }
   }
   newNode.setNext(current.getNext());
   current.setNext(newNode);
   size ++;
  }
 public String get(int index){

 }
 public String set(int index, String value){

 }
 public String toString(){

 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
