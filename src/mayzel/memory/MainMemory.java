package mayzel.memory;

public class MainMemory {

	private int totalBytes;
	private String[][] memory;
	public MainMemory(int totalBytes) {
		this.totalBytes = totalBytes;
		memory = new String[(totalBytes/128)][128];
		
		//fill memory with nothing (-)
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				memory[i][j] = "-";
			}
		}
	}

	public boolean allocate(int pid, int numBytes){
		//allocate first come way
		boolean allocated = false;
		int availableMemory = 0;
		//count free memory
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				if(memory[i][j].equals("-")){
					availableMemory++;
				}
			}
		}
		//allocate memory
		if(numBytes < availableMemory){
			for(int i=0;i<memory.length;i++){
				for(int j=0;j<memory[i].length;j++){
					if(memory[i][j].equals("-") && numBytes !=0){
						memory[i][j] = String.valueOf(pid);
						numBytes--;
					}
				}
			}
			allocated = true;
		}
		return allocated;
		
	}
	
	public void free(int pid){
		//free anything with specified pid from memory (0-9)
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				if(memory[i][j].equals(String.valueOf(pid))){
					memory[i][j] = "-";
				}
			}
		}
	}
	
	public String print(){
		//print memory
		StringBuilder info = new StringBuilder();
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				info.append(memory[i][j]);
			}
			info.append("\n");
		}
		return info.toString();
	}
	
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
