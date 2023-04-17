package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double elements = 0;
        double allScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                elements++;
                allScore += subject.score();
            }
        }
        return allScore / elements;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double elements = 0;
            double allScore = 0;
            for (Subject subject : pupil.subjects()) {
                elements++;
                allScore += subject.score();
            }
            Label label = new Label(pupil.name(), allScore / elements);
            labels.add(label);
        }
        return labels;
    }

    private static Map<String, Integer> tempMap(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.computeIfPresent(subject.name(), (key, value) -> value + subject.score());
                map.putIfAbsent(subject.name(), subject.score());
            }
        }
        return map;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = tempMap(pupils);
        for (String key : map.keySet()) {
            Label label = new Label(key, map.get(key) / (double) pupils.size());
            labels.add(label);
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double allScore = 0;
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
            }
            Label label = new Label(pupil.name(), allScore);
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = tempMap(pupils);
        for (String key : map.keySet()) {
            Label label = new Label(key, map.get(key));
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}