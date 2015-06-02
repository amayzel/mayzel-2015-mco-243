package mayzel.scheduler;

import java.util.List;

public class FIFO implements SchedulerAlgorithm {

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return list.get(0);
	}

}
