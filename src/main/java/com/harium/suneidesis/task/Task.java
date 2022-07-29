package com.harium.suneidesis.task;

public interface Task {

    /**
     * Method to check if requirements for this task is met
     * @return true if task can start
     */
    boolean canStart();

    /**
     * Method to check if the task is currently happening
     * @return if task is in progress
     */
    boolean isInProgress();

    /**
     * Method to check if the task finished to run
     * @return if task is finished
     */
    boolean isDone();

    /**
     * Method to actually execute the task
     * @return if task can be executed
     */
    boolean start();

}
