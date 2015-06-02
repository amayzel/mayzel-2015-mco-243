package mayzel.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	private static final int QUANTUM = 10;
	
	List<FakeProcess> list;
	SchedulerAlgorithm algorithm;
	
	public Scheduler(SchedulerAlgorithm algorithm) {
		
		this.algorithm = algorithm;
		list = new ArrayList<FakeProcess>();
				
	}
	
	public void run(){
		while(true){
			FakeProcess process = algorithm.getNextProcess(list);
			list.remove(process);
		
			process.run(QUANTUM);
			
			if(process.isStillRunning()){
				list.add(process);
			}
		}
	}

}
