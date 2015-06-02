package mayzel.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SchedulerTest {
	
	private Random random;
	private List<FakeProcess> processes1;
	private List<FakeProcess> processes2;
	private List<FakeProcess> processes3;
	private Scheduler scheduler1;
	private Scheduler scheduler2;
	private Scheduler scheduler3;
	public SchedulerTest(){
		random = new Random();
		processes1 = new ArrayList<FakeProcess>();
		processes2 = new ArrayList<FakeProcess>();
		processes3 = new ArrayList<FakeProcess>();
	}
	
	public void createProcesses(){
		for(int i=0;i<200;i++){
			int priority = random.nextInt(10) + 1;//higher num = lower priority
			int time = random.nextInt(100);
			processes1.add(new FakeProcess(priority, time));
			processes2.add(new FakeProcess(priority, time));
			processes3.add(new FakeProcess(priority, time));

		}
	}
	
	public static void main(String [] args){
		SchedulerTest st = new SchedulerTest();
		st.createProcesses();
		
		System.out.println("FIFO algorithm:");
		st.scheduler1 = new Scheduler(new FIFO(),st.processes1);
		long start = System.currentTimeMillis();
		st.scheduler1.run();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println("Priority algorithm:");
		st.scheduler2 = new Scheduler(new Priority(),st.processes2);
		long start2 = System.currentTimeMillis();
		st.scheduler2.run();
		long end2 = System.currentTimeMillis();
		System.out.println(end2-start2);
		
		System.out.println("Shortest First algorithm:");
		st.scheduler3 = new Scheduler(new ShortestFirst(),st.processes3);
		long start3 = System.currentTimeMillis();
		st.scheduler3.run();
		long end3 = System.currentTimeMillis();
		System.out.println(end3-start3);
		
	}

}
