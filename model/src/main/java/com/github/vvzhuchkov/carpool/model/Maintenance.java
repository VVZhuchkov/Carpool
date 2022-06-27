package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.security.Provider;
import java.util.Date;
import java.util.Objects;

public class Maintenance extends Entity implements Serializable {
    private String problem;
    private String startService;
    private Date expectedFinishTime;
    private Date finishService;
    private boolean isRepaired;
    private String comment;

    public Maintenance(int id, String problem, String startService, boolean isRepaired) {
        super(id);
        this.problem = problem;
        this.startService = startService;
        this.isRepaired = isRepaired;
    }

    public Maintenance(int id, String problem, String startService, Date expectedFinishTime, boolean isRepaired) {
        super(id);
        this.problem = problem;
        this.startService = startService;
        this.expectedFinishTime = expectedFinishTime;
        this.isRepaired = isRepaired;
    }

    public Maintenance(int id, String problem, String startService, Date expectedFinishTime, Date finishService, boolean isRepaired) {
        super(id);
        this.problem = problem;
        this.startService = startService;
        this.expectedFinishTime = expectedFinishTime;
        this.finishService = finishService;
        this.isRepaired = isRepaired;
    }

    public Maintenance(int id, String problem, String startService, Date expectedFinishTime, Date finishService, boolean isRepaired, String comment) {
        super(id);
        this.problem = problem;
        this.startService = startService;
        this.expectedFinishTime = expectedFinishTime;
        this.finishService = finishService;
        this.isRepaired = isRepaired;
        this.comment = comment;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getStartService() {
        return startService;
    }

    public void setStartService(String startService) {
        this.startService = startService;
    }

    public Date getExpectedFinishTime() {
        return expectedFinishTime;
    }

    public void setExpectedFinishTime(Date expectedFinishTime) {
        this.expectedFinishTime = expectedFinishTime;
    }

    public Date getFinishService() {
        return finishService;
    }

    public void setFinishService(Date finishService) {
        this.finishService = finishService;
    }

    public boolean isRepaired() {
        return isRepaired;
    }

    public void setRepaired(boolean repaired) {
        isRepaired = repaired;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Service{" +
                ", problem='" + problem + '\'' +
                ", startService='" + startService + '\'' +
                ", expectedFinishTime=" + expectedFinishTime +
                ", finishService=" + finishService +
                ", isRepaired=" + isRepaired +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maintenance maintenance = (Maintenance) o;
        return isRepaired == maintenance.isRepaired && problem.equals(maintenance.problem) &&
                startService.equals(maintenance.startService) && Objects.equals(expectedFinishTime, maintenance.expectedFinishTime)
                && Objects.equals(finishService, maintenance.finishService) && Objects.equals(comment, maintenance.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problem, startService, expectedFinishTime, finishService, isRepaired, comment);
    }
}
