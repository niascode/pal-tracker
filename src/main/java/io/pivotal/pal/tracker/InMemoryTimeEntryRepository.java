package io.pivotal.pal.tracker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long,TimeEntry> timeEntryList;

    public int getNextIndex() {
        nextIndex +=1;
        return nextIndex;
    }

    private int nextIndex = 0;

    public InMemoryTimeEntryRepository() {
        this.timeEntryList = new HashMap<>();
        nextIndex=0;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry.getId()==0){
            timeEntry.setId(getNextIndex());
        }
        timeEntryList.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntryList.get(id);
    }


    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryList.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry foundTimeEntry = this.find(id);
        if (foundTimeEntry==null){
            return null;
        }
        timeEntry.setId(id);
        timeEntryList.replace(id,timeEntry);
        return this.find(id);
    }

        public void delete(long id) {
        timeEntryList.remove(id);
    }

}
