package mayzel.scheduler;

public class FakeProcess {

		int priority;
		int timeToCompletion;
		
		
		public FakeProcess(int priority, int timeToCompletion) {
			this.priority = priority;
			this.timeToCompletion = timeToCompletion;
		}

		public void run(int quantum){
			timeToCompletion-=quantum;
		}
		
		public boolean isStillRunning(){
			return timeToCompletion > 0;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public int getTimeToCompletion() {
			return timeToCompletion;
		}

		public void setTimeToCompletion(int timeToCompletion) {
			this.timeToCompletion = timeToCompletion;
		}
		
		
}
