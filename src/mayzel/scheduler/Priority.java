package mayzel.scheduler;

import java.util.List;

public class Priority implements SchedulerAlgorithm{

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return getHighestPriority(list);
	}
	
	public FakeProcess getHighestPriority(List<FakeProcess>list){
		FakeProcess highestPriority= list.get(0);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getPriority() < highestPriority.getPriority()){
				highestPriority = list.get(i);
			}
		}
		return highestPriority;
	}

}
