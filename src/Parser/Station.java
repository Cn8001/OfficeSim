
package Parser;

import java.util.*;

public class Station {
    
    String name;
    float maxCapacity;
    boolean mutliFlag;
    boolean fifoflag;
    float speed;
    float plusMinus;
    ArrayList<Task> defaultTasks = new ArrayList<>(); 

    ArrayList<ArrayList<Task>> taskChannels = new ArrayList<>(); //channels for the multi task stations. If the station isn't multiflagged, get only thee first channel.

    

    public Station(String name, float maxValue, boolean mutliFlag, boolean fifoflag, float speed, float plusMinus) {
        this.name = name;
        this.maxCapacity = maxValue;
        this.mutliFlag = mutliFlag;
        this.fifoflag = fifoflag;
        this.speed = speed;
        this.plusMinus = plusMinus;

        for(int i = 0; i < maxCapacity; i++) {
            taskChannels.add(new ArrayList<Task>());
        }
    }
    public ArrayList<ArrayList<Task>> getTaskChannels() {
        return taskChannels;
    }
    public ArrayList<Task> getDefaultTasks() {
        return defaultTasks;
    }

    public void setDefaultTasks(ArrayList<Task> defaultTasks) {
        this.defaultTasks = defaultTasks;
    }

    public float getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(float plusMinus) {
        this.plusMinus = plusMinus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(float maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isMutliFlag() {
        return mutliFlag;
    }

    public void setMutliFlag(boolean mutliFlag) {
        this.mutliFlag = mutliFlag;
    }

    public boolean isFifoflag() {
        return fifoflag;
    }

    public void setFifoflag(boolean fifoflag) {
        this.fifoflag = fifoflag;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public boolean isPlusMinus(){
        if(this.plusMinus!=0){
            return true;
        } else{
            return false;
        }
    }
    
    public double calculateSpeed(){
        if(this.isPlusMinus()){
            Random r1=new Random(System.currentTimeMillis());
            double randomDouble=0;
            do{
                randomDouble=r1.nextDouble(-this.plusMinus, this.plusMinus+1);
            } while(randomDouble==0);
            return (double)this.speed*(randomDouble);
        }else{
            return (double)this.speed;
        }
    }

    public ArrayList<Task> getFreeChannel(){
        ArrayList<ArrayList<Task>> allChannels = (ArrayList)taskChannels.clone();
        Collections.sort(allChannels, new ChannelComparator());
        return allChannels.get(0);
    }
}

class ChannelComparator implements Comparator<ArrayList<Task>>{

    public int compare(ArrayList<Task> task1, ArrayList<Task> task2) {
        if(task1.size()==task2.size()){
            return 0;
        }else if(task1.size()>task2.size()){
            return 1;
        }else{
            return -1;
        }
    }
}

