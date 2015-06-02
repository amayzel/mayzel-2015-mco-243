package mayzel.memory;

public class Main {
	
	public static void main(String[] args){
		//Testing that memory allocater works
		MainMemory mainMemory = new MainMemory(1152);
		System.out.println(mainMemory.print());
		if(!mainMemory.allocate(4,16)){
			System.out.println("Error! Ran out of memory for this allocation!");
		}
		System.out.println(mainMemory.print());
		if(!mainMemory.allocate(7,6)){
			System.out.println("Error! Ran out of memory for this allocation!");
		}
		System.out.println(mainMemory.print());
		if(!mainMemory.allocate(5,3)){
			System.out.println("Error! Ran out of memory for this allocation!");
		}
		System.out.println(mainMemory.print());
		if(!mainMemory.allocate(7,2)){
			System.out.println("Error! Ran out of memory for this allocation!");
		}
		System.out.println(mainMemory.print());
		mainMemory.free(7);
		System.out.println(mainMemory.print());
		if(!mainMemory.allocate(9,14)){
			System.out.println("Error! Ran out of memory for this allocation!");
		}
		System.out.println(mainMemory.print());
		
		
	}

}
