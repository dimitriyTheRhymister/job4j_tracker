package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    void sortByPriorityJob() {
        List<Job> jobs = Arrays.asList(
                new Job("Petr", 32),
                new Job("Petr", 31)
        );
        List<Job> expected = new ArrayList<>();
        Job j1 = new Job("Petr", 31);
        Job j2 = new Job("Petr", 32);
        expected.add(j1);
        expected.add(j2);
        jobs.sort(new SortByPriorityJob());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void sortDescByPriorityJob() {
        List<Job> jobs = Arrays.asList(
                new Job("Petr", 31),
                new Job("Petr", 32)
        );
        List<Job> expected = new ArrayList<>();
        Job j1 = new Job("Petr", 32);
        Job j2 = new Job("Petr", 31);
        expected.add(j1);
        expected.add(j2);
        jobs.sort(new SortDescByPriorityJob());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void sortByNameJob() {
        List<Job> jobs = Arrays.asList(
                new Job("Petr", 32),
                new Job("Ivan", 31)
        );
        List<Job> expected = new ArrayList<>();
        Job j1 = new Job("Ivan", 31);
        Job j2 = new Job("Petr", 32);
        expected.add(j1);
        expected.add(j2);
        jobs.sort(new SortByNameJob());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void sortDescByNameJob() {
        List<Job> jobs = Arrays.asList(
                new Job("Ivan", 31),
                new Job("Petr", 32)
        );
        List<Job> expected = new ArrayList<>();
        Job j1 = new Job("Petr", 32);
        Job j2 = new Job("Ivan", 31);
        expected.add(j1);
        expected.add(j2);
        jobs.sort(new SortDescByNameJob());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenCompatorByNameAndProrityDifferentNames() {
        Comparator<Job> cmpNamePriority = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Ivan", 31),
                new Job("Petr", 32)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndProritySameNames() {
        Comparator<Job> cmpNamePriority = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Ivan", 32),
                new Job("Ivan", 31)
        );
        assertThat(rsl).isGreaterThan(0);
    }

}