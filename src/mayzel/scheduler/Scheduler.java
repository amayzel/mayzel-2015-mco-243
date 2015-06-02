package mayzel.scheduler;

import java.util.List;

public class Scheduler {

	private static final int QUANTUM = 10;
	private List<FakeProcess> list;
	private SchedulerAlgorithm algorithm;
	
	public Scheduler(SchedulerAlgorithm algorithm,List<FakeProcess> list) {
		
		this.algorithm = algorithm;
		this.list = list;
				
	}
	
	public void run(){
		while(true){
			FakeProcess process = algorithm.getNextProcess(list);
			list.remove(process);
		
			process.run(QUANTUM);
			
			if(process.isStillRunning()){
				list.add(process);
			}
			if(list.isEmpty()){
				break;
			}
		}
	}

}
