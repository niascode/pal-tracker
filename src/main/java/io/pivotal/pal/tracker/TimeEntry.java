package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }

    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate date, int hour) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hour;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hour) {
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hour;
    }

    public TimeEntry(Object id, long projectId, long userId, LocalDate date, int hour) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hour;
    }

    //empty constructor
    public TimeEntry() {

    }

    public Long getId() {
        return this.id;
    }
}
