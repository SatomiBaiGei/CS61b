public class LinkedListDeque<Jiang>{
	private Node first;
	private int size;
	private class Node{
		public int item;
		public Node next;
		public Node prev;
		public Node(Node p, int i, Node n){
			item = i;
			next = n;
			prev = p;
		}
	}
	public LinkedListDeque(int x){
		size = 1;
		first = new Node(null, x, null);
	}
	public void addFirst(){
		size += 1
		first = new Node(null, x, null);
	}
	public addLast(){
		size += 1;
		Node p = first;
		while(p.next != null){
			p = p.next;
		}
		p.next = new Node(null,x, null);

	}


	public size(){
		return size;
	}

	public get(){
		int y = size();
		int[] getNumber = new int[y];
		IntList p = this;
		int x = 0;
		while ( p != null){
			getNumber[x] = p.first;
			p = p.rest;
			x++;
		}

		return getNumber[i];
	}
	public static void main(String[] args) {
		
	}
}