
import java.util.ArrayList;
public class LinkedListDeque<T>{
	private Node sentinel;
	private int size;
	private class Node{
		public T item;
		public Node next;
		public Node prev;
		public Node(Node p, T i, Node n){
			item = i;
			next = n;
			prev = p;
		}
	}

	public LinkedListDeque(){
		size = 0;
		sentinel = new Node(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}
	public void addFirst(T item){
		size += 1;
		sentinel.next = new Node(sentinel, item, sentinel.next);
		sentinel.next.next.prev = sentinel.next;

	}
	public void addLast(T item){
		size += 1;

		sentinel.prev.next = new Node(sentinel.prev, item, sentinel);
		sentinel.prev = sentinel.prev.next;
	}


	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return (this.size == 0);
	}

	public void printDeque(){
		Node p = sentinel.next;
		while(p != sentinel){

			System.out.print(p.item + " ");
			p = p.next;
		}
	}

	public T removeFirst(){
		if (isEmpty()){
			return null;
		}
		T res = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size -= 1;
		return res;
	}

	public T removeLast(){
		if(isEmpty()){
			return null;
		}
		T res = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size -= 1;
		return res;
		
	}

	public T get(int index){
		int length = size;
		Node tar = sentinel.next;
		if(index > length-1){
			return null;
		}
		for(int i = 0; i < index; i++){
			tar = tar.next;
		}
		return tar.item;
	}

	public T getRecursive(int index){
		int length = size;
		Node tar = sentinel.next;
		if (index > length-1){
			return null;
		}
		return trans(sentinel.next, index);


		return tar.item
	}


	public T trans(Node n, int i){
		if(i == 0){
			return n.item;
		}
		return trans(n.next, i -1)
	}


/**
	public T get(int index){
		Node p = sentinel.next;
		ArrayList<T> list = new ArrayList<T>(size());
		if(isEmpty()){
			return null;
		}
		while(p != null){
		list.add(p.item);
		p = p.next;
	}
	T number = list.get(index);
		return number;

	}
	*/


 
	public static void main(String[] args) {
		LinkedListDeque<Integer> L = new LinkedListDeque<Integer>();
		L.addFirst(10);
		L.addFirst(5);
		L.addLast(20);

		/**
		System.out.println(L.size());
		
		L.removeFirst();
		L.printDeque();
		*/
		L.get(1);
		
	}
}