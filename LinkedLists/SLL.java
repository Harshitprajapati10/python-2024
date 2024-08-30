class SLL {
  private Node head;
  private Node tail;
  private int size;

  public SLL() {
    this.size = 0;
  }

  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  // InsertFirst method
  public void insertFirst(int val) {
    Node node = new Node(val);
    node.next = head;
    head = node;
    if (tail == null) {
      tail = head;
    }
    size += 1;
  }

  // Display method
  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.println("End!");
  }

  // Insert Last
  public void insertLast(int value) {
    if (tail == null) {
      insertFirst(value);
      return;
    }
    Node node = new Node(value);
    tail.next = node;
    tail = node;
    size ++;
  }

  //Insert at given index
  public void insert(int value, int index){
    if(index == 0){
      insertFirst(value);
      return;
    }
    if(index == size){
      insertLast(value);
      return;
    }
    Node temp = head;
    for (int i = 1; i < index; i++) {
      temp = temp.next;
    }
    Node node = new Node(value, temp.next);
    temp.next = node;
    size++;
  }


  //DeleteFirst
  public int deleteFirst(){
    int value = head.value;
    head = head.next;
    if(head == null){
      tail = null;
    }
    size --;
    return value;
  }

  //deleteLast
  public int deleteLast(){
    if(size <= 1){
      deleteFirst();
    }
    Node secondLast = get(size-2);
    int val = tail.value;
    tail = secondLast;
    tail.next = null;
    return val;
  }
  public Node get(int index){
    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }


  // Deletion from particular index
  public int delete(int index){
    if(index == 0){
      return deleteFirst();
    }
    if(index == size-1){
      return deleteLast();
    }
    Node prev = get(index-1);
    int val = prev.next.value;
    prev.next = prev.next.next;
    return val;
  }

  // Finding a node by given value
  public Node find(int val){
    Node node = head;
    while(node != null){
      if(node.value ==  val){
        return node;
      }
      node = node.next;
    }
    return null;
  }

  public static void main(String[] args) {
    SLL list = new SLL();
    list.insertFirst(3);
    list.insertFirst(4);
    list.insertFirst(89);
    list.insertFirst(8);
    list.display();
    list.insertLast(91);
    list.display();
    list.insert(13,2);
    list.insert(54, 5);
    list.display();
    list.deleteFirst();
    list.display();
    list.deleteLast();
    list.display();
    list.delete(4);
    list.display();
    System.out.println(list.find(13));
    list.display();
  }
}