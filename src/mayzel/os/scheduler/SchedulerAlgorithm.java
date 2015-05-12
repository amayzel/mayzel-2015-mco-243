package mayzel.os.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {

	//method returns next fakeProcess based on priority
	FakeProcess getNextProcess( List<FakeProcess> list);
	
}
