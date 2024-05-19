package Parser;
import Frontend.EventTemplate;
import java.util.ArrayList;

public class Job {
    
    private JobType jobType;
    private float startTime;
    private float duration;
    private String jobId;
    private float jobTardiness = 0;
    private float jobFinishTime = 0;
    private float simulativeFinishTime = 0;
    

    

    

    ArrayList<Task> tasks = new ArrayList<Task>();
    ArrayList<EventTemplate> eventTemplates = new ArrayList<EventTemplate>();

    public Job(String jobId,JobType jobType, float startTime, float duration) {
        this.jobId = jobId;
        this.jobType = jobType;
        this.startTime = startTime;
        this.duration = duration;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
        tasks = jobType.getTasks();
    }

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return jobId;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }


    public String toString(){
        return "\nJobID: "+this.jobId+"\n"+this.jobType.toString()+"\nStart time: "+this.startTime+"\nDuration: "+this.duration;
    }
    public ArrayList<EventTemplate> getEventTemplates() {
        return eventTemplates;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setEventTemplates(ArrayList<EventTemplate> eventTemplates) {
        this.eventTemplates = eventTemplates;
    }

    public void calculateJobTardiness(){
        jobFinishTime = getDuration() + getStartTime();
        float maxLastEventTime = 0;
        for(EventTemplate ev : getEventTemplates()){
            if(ev.getTime() > maxLastEventTime){
                maxLastEventTime = ev.getTime();
            }
        }
        float lastEventTime = maxLastEventTime;
        simulativeFinishTime = lastEventTime;
        jobTardiness = lastEventTime - jobFinishTime;
    }

    public float getJobTardiness() {
        return jobTardiness;
    }

    public void setJobTardiness(float jobTardiness) {
        this.jobTardiness = jobTardiness;
    }

    public float getJobFinishTime() {
        return jobFinishTime;
    }

    public void setJobFinishTime(float jobFinishTime) {
        this.jobFinishTime = jobFinishTime;
    }
    public float getSimulativeFinishTime() {
        return simulativeFinishTime;
    }

    public void setSimulativeFinishTime(float simulativeFinishTime) {
        this.simulativeFinishTime = simulativeFinishTime;
    }
}
