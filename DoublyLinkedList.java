public class DoublyLinkedList
{

  private int size = 0;
  private Node root = null;
  
  public void add(int x, Node addedNode) {
    Node newNode = addedNode;
    
    if( x > this.size)
      System.out.println("Index " + x + " does not exist.");
    else 
    {
      if (this.root == null) {
        this.root = newNode;
      }
      else 
        if (x == 0) {
        newNode.setNext(root);
        this.root = newNode;
      }
      else 
        if (x == this.size) 
      {
        Node current = this.root;
        while (current.getNext() != null) {
          current = current.getNext();
        }
        current.setNext(newNode);
      }
      else 
      {
        Node current = this.root;
        for(int i = 0; i < x - 1; i++) {
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
        if(newNode.getName().compareTo(currentNode.getName())<=0)
        {
          newNode.setId(i);
          this.add(i, newNode);
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
          currentNode = currentNode.getNext();
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
  
  public void printBackwards()
  {
    
  }
  
   public void delete(int x) 
   {
    Node tmp = this.root;
    int i = 0;
    
    if (x == 0) 
    {
      this.root = this.root.getNext();
    }
    while (tmp.getNext() != null && i < x-1) 
    {
      
      tmp = tmp.getNext();
      i++;
    }
    if (x < size && x > 0) 
    {
      tmp.setNext(tmp.getNext().getNext());
    size--;
    }    
  }
    
  public void destroy() 
  {
    this.root = null;
  }

}