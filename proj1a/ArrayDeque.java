public class arrayDeque<T>{
	private int size;
	private float usage;
	private int nextFirst;
	private int nextLast;
	private T[] items;
	public arrayDeque(){
		items = (T[]) new Object[8];
		size = 0;
		usage = 0;
		nextFirst = 1;
		if(nextFirst == 7){
			nextLast = 0;
		}
		nextLast = nextFirst+1;
	}


	//Create random number for nextFirst and nextLast
	private static int getRandomNumberInRange(int min, int max){
		if (min >= max){
			throw new IllegalAccessException("max need to be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min)+ 1)+min;
	}

	private boolean usageCheck(){
		return (usage < 0.25 &&(items.length > 16));
	}

	public void resize(int capacity){
		//condition that the usage of original array are enough for the adding content
		//then new array use the original size. 
		//else enlarge the size by factor 2 to increase the process speed.
		if(usageCheck()||size == items.length){

			int newSize = items.length;
		}

			newSize *= 2;


		//if the length and usage of array greater than 25% and 16, then 
		//create a new array call "a" which sizes twice larger than original one,
		//then put "items" in the second spot of new "a".
		//the empty one is to prevent the case "addFast".
		T[] a =(T[]) new Object[tarSize];
	

		int firstIndex = 0;
		int lastIndex = 0;
		int newSize = 0;

		if(usageCheck()){
		//to find the elements in array without any null variable.
			for(int i = 0; i < items.length; i++){

				//take out first spot that contain element in "items"
				if(items[i] == null && items[i + 1] != null ){
					firstIndex = i + 1;
				}

				//take out last spot that contain element in "items"
				if(items[i] != null && items[i+1] == null ){
					lastIndex = i;
					}


				}
				//calculate the size of "items"
				newSize = lastIndex - firstIndex + 1;
				
				//copy the "items" into "a"
				System.arraycopy(items,firstIndex,a,1,newSize);

				//point back to new array.
				items = a;
				
		}

		//this is the condition that the original array can handle the data that put it in the box.
		else{
			System.arraycopy(items,firstIndex,a,1,items.length);
			items = a;

		}


			
			
	}

	private int pointerAtFirst(int nextFirst){
		if(nextFirst != 0 || nextFirst < size){
			nextFirst -= 1;
		}
		nextFirst = items.length - 1;
	}
		return nextFirst;

	private int pointerAtBack(int nextLast){
		if(nextFirst != items.length -1 || nextFirst < items.length){
			nextLast += 1;
		}
		nextLast = 0
		return nextLast;
	}


	public void addFirst(T x){
		
		resize();
		items[nextFirst] = x;
		size += 1;
		usage = (float)size/(float)items.length;
		nextFirst = pointerAtFirst(nextFirst);



	}
	public void addLast(T x){
	/**	if(size == items.length || usage >= 0.25){
			resize(size + 1);
		}

		*/
		resize()
		items[size] = x;
		size += 1;
		usage = (float)size/(float)items.length;
		nextLast = pointerAtBack(nextLast);
	}
	public boolean isEmpty(){
		return size == 0;

	}
	public int size(){
		return size;

	}
	public void printDeque(){
		for(int j = 0; j< items.length-1; j++){
			int tempValue = items[j];
			System.out.println(tempValue+ " ");
		}
	}
	public int removeFrontPointer(){
		if(nextFirst != items.length - 1){
			nextFirst -= 1;
		}
		nextFirst = 0;
	}
	public int removeBackPointer(){
		if(nextLast != 0){
			nextLast -=1;
		}
		nextLast = items.length -1;
		return nextLast;
	}
	public T removeFirst(){
		int y = removeFrontPointer(nextFirst);
		T value = items[y];
		items[y] = null;
		size -= 1;
		usage = (float)size /(float) items.length;
		nextFirst = y;
		resize();
		return value;
	}
	public T removeLast(){
		int y = removeBackPointer(nextLast);
		T returnItem = items[y];
		items[y] = null;
		size -= 1;
		usage = (float)size /(float)items.length;
		nextLast = y;
		return returnItem;
	}
	public T get(int index){
		if (index >= items.size){
			return null;
		}
		return items[i];
	}

