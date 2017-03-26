public class DoublyLinkedList
{

  private int size = 0;
  private Node root = null;
  
  public void add(int index, Node addedNode) {
    Node newNode = addedNode;
    
    if( index > this.size)
      //error
      System.out.println("Index " + index + " does not exist.");
    else {
      // if list is empty, newNode is root
      if (this.root == null) {
        this.root = newNode;
      }
      // adds to front of list
      else if (index == 0) {
        newNode.setNext(root);
        this.root = newNode;
      }
      else if (index == this.size) {
        // adds to end of list
        Node current = this.root;
        while (current.getNext() != null) {
          current = current.getNext();
        }
        current.setNext(newNode);
      }
      else {
        // adds to middle of list
        Node current = this.root;
        for(int i = 0; i < index - 1; i++) {
          current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
      }
      
    this.size++;
    
    }
  }
  
  public void insert(Node newNode)
  {
      int i = newNode.getId();
      Node currentNode = this.root;
      while(currentNode != null)
      {        
        if(newNode.getName().compareTo(currentNode.getName())==1)
        {
          add(i, newNode);
        }
        currentNode = currentNode.getNext();
        i++;
      }
  }
  
  public void find(Node findNode)
  {
      String isFound = null;
      Node currentNode = this.root;
      
      while(currentNode != null)
      {
        if(currentNode.getName() != findNode.getName())
        {
          currentNode = currentNode.getNext();
        }
        else if(currentNode.getName() == findNode.getName())
        {
          isFound = "Node found.";
        }
      }
      System.out.println(isFound);   
  }
  
  public void printList(){
      
      Node currentNode = this.root;
      while(currentNode != null)
      {
        
        System.out.println(currentNode.toString());
        currentNode = currentNode.getNext();
      }
      
  }
    

}