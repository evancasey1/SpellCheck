/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure
 */
public class StringSet {

  StringNode [] table;		// Hash table - collisions resolved through chaining.
  int size;			
  int capacity;			// Allocated memory (size of the hash table).

  public StringSet() {
    size = 0;
    capacity = 1000;
    table = new StringNode[capacity];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
   */
  public void insert(String key) {

    if (size == capacity) {
      //Todo: need to expand the hash table and rehash its contents. 

    }
    size++;
    int i = hash(key);
    if (table[i] != null){
      StringNode curr = table[i];
      while(curr.getNext() != null)
        curr = curr.getNext();
      curr.setNext(new StringNode(key.toLowerCase(), null));
    }
    else {
      table[i] = new StringNode(key.toLowerCase(), table[i]);
    }
  }

  /*
   * finds if a String key is present in the data structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    int i = hash(key);
    for (StringNode curr = table[i]; curr != null; curr = curr.getNext()) {
      if (curr.getKey().equals(key.toLowerCase())){
        return true;
      } 
    }
    return false;
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    for (int i = 0; i < capacity; i++) {
      for (StringNode curr = table[i]; curr != null; curr = curr.getNext()) 
        System.out.println(curr.getKey());
    }
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int h = 0;
    // Compute a polynomial hash function for the String k. Make sure that the hash value h returned is a proper index 
    // in the hash table, ie. in the range [0...capacity-1]. 
    k = k.toLowerCase();
    int x = 2917;
    for (int i = 0; i < k.length(); i++) {
      h = ((h * x) + (int) k.charAt(i)) % (capacity - 1);
    }
    return h;
  }

}
