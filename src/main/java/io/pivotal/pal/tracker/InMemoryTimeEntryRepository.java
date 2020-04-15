package io.pivotal.pal.tracker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository {

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

    public TimeEntry find(TimeEntry id) {
        return timeEntryList.get(id.getId());
    }


    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryList.values());
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry foundTimeEntry = this.find(id);
        if (foundTimeEntry==null){
            return null;
        }
        timeEntryList.replace(id,timeEntry);
        return this.find(id);
    }

    public void delete(Long id) {
        timeEntryList.remove(id);
    }

    public TimeEntry find(long timeEntryId) {
        return timeEntryList.get(timeEntryId);
    }
}
