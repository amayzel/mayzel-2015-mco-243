package mayzel.scheduler;

import java.util.List;

public class ShortestFirst implements SchedulerAlgorithm  {

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return getShortest(list);
	}
	
	public FakeProcess getShortest(List<FakeProcess> list){
		FakeProcess shortest = list.get(0);
		for(int i=0;i<list.size();i++){
			if(list.get(0).getTimeToCompletion() < shortest.getTimeToCompletion()){
				shortest = list.get(i);
			}
		}
		return shortest;
		
	}

}
