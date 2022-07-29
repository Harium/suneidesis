package com.harium.suneidesis.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgentTest {

    Agent agent;

    @Before
    public void setUp() {
        agent = new Agent();
    }

    @Test
    public void testNoTasks() {
        assertTrue(agent.update());
    }

    @Test
    public void testSingleTask() {
        Task immediate = mock(Task.class);
        when(immediate.isDone()).thenReturn(true);
        agent.addTask(immediate);

        assertTrue(agent.update());
        assertNull(agent.currentTask);
    }

    @Test
    public void testMultipleTasks() {
        Task task1 = mock(Task.class);
        when(task1.isDone()).thenReturn(false);
        agent.addTask(task1);

        Task task2 = mock(Task.class);
        when(task2.isDone()).thenReturn(true);
        agent.addTask(task2);

        assertFalse(agent.update());
        when(task1.isDone()).thenReturn(true);
        assertTrue(agent.update());

        assertEquals(task2, agent.currentTask);
    }

}
