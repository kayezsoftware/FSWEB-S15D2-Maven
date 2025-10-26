package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String owner) {
        return switch (owner.toLowerCase()) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            case "all" -> getUnion(getUnion(annsTasks, bobsTasks), carolsTasks);
            default -> unassignedTasks;
        };
    }

    public Set<Task> getUnion(Set<Task> s1, Set<Task> s2) {
        Set<Task> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public Set<Task> getIntersection(Set<Task> s1, Set<Task> s2) {
        Set<Task> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }

    public Set<Task> getDifferences(Set<Task> s1, Set<Task> s2) {
        Set<Task> result = new HashSet<>(s1);
        result.removeAll(s2);
        return result;
    }

}
