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
   Node newNode = new Node(value);
   if(size() ==0){
     start = newNode;
     end = newNode;
   }
   else{
     end.setNext(newNode);
     newNode.setPrev(end);
     end = newNode;
   }
   size++;
   return true;

 }
 public void add(int index, String value){
   try{
     if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
     }
   }catch(NullPointerException e){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   Node newNode = new Node(value);
       if (size == 0) {
           start = newNode;
           end = newNode;
       }
       else if (index == size) {
           end.setNext(newNode);
           newNode.setPrev(end);
           end =newNode;
       }
       else if (index == 0) {
           start.setPrev(newNode);
           newNode.setNext(start);
           start = newNode;
       }
       else {
           Node newPrev = move(index - 1);
           Node newNext = move(index);
           newNode.setNext(newNext);
           newPrev.setNext(newNode);
           newNext.setPrev(newNode);
           newNode.setPrev(newPrev);
       }
       size ++;
  }
 public String get(int index){
   if(index < 0 || index >= size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
   Node current=start;
   for(int i = 0; i <= index; i++){
     current = current.getNext();
   }
   return current.getData();
 }
 public String set(int index, String value){
   if(index < 0 || index >= size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
   Node current=start;
   for(int i = 0; i <= index; i++){
     current = current.getNext();
   }
   String old= current.getData();
   current.setData(value);
   return old;
 }
 //private helper
 private Node move(int index){
  if(index < 0 || index >= size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
  if (index == 0) return start;
  if (index == size - 1) return end;
  Node current = start;
  for(int i = 0; i < index; i++){
    current = current.getNext();
  }
  return current;
}
 public String toString(){
   String result = "";
   if(size()==0){
     return "[]";
   }
	 if (start != null) {
		Node current = start.getNext();
		while (current != null) {
		    result += current.getData().toString();
        if(current.getNext() != null){
          result += ", ";
        }
				current = current.getNext();
		}
	}
  return "[" + result + "]";
 }
 public String toStringReversed(){
   String result = "";
   if(size()==0){
     return "[]";
   }
	 if (end != null) {
		Node current = end;
		while (current != null) {
		    result += current.getData();
        if(current.getPrev() != null){
          result += ", ";
        }
				current = current.getPrev();
		}
	}
  return "[" + result + "]";
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
 public String remove(int index){
   try{
     if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
     }
   }catch(NullPointerException e){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   String oldValue= "";
       if (size == 1) {
         oldValue = start.getData();
         start = null;
         end = null;
       }
       else if (index == 0) {
         oldValue = start.getData();
         Node freshStart = start.getNext();
         freshStart.setPrev(null);
         start.setNext(null);
         start = freshStart;
       }
       else{
     Node old = move(index);
     oldValue = old.getData();
     old.getPrev().setNext(old.getNext());//set the previous one's next to the old node's next
     old.getNext().setPrev(old.getPrev());//set the next one's previous to the old node's previous
     old.setNext(null);
     old.setPrev(null);
   }
   size--;
   return oldValue;
 }
 public void extend(MyLinkedList other){
   end.setNext(other.start);
   other.start.setPrev(end);
   size += other.size();
   other.size = 0;
   other.start = null;
   other.end = null;
 }
}
