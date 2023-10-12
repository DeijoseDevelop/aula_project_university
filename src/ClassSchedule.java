package src;

import java.time.*;

public class ClassSchedule {
    private static int countClassSchedules;
    private int id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public ClassSchedule() {
        this.id = ++ClassSchedule.countClassSchedules;
    }

    public ClassSchedule(
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime
    ) {
        this.id = ++ClassSchedule.countClassSchedules;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartAndEndTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void releaseSchedule(
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime
    ) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public String getRangeTime() {
        return String.format(
            "From %s to %s",
            this.startTime.toString(),
            this.endTime.toString()
        );
    }

    @Override
    public String toString() {
        return String.format("ClassSchedule(id=%d)", this.id);
    }
}
