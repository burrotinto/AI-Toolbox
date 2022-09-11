package de.burrotinto.decisionTrees;

import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class DataSet<T> {

    private final List<Data<T>> data;
    private final List<String> attributeNames;

    public DataSet() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public DataSet(List<Data<T>> data) {
        this(data, new ArrayList<>());
    }

    public Data<T> getExample() {
        return data.get(new Random().nextInt(data.size()));
    }

    public List<Integer> getNumberOfAllAttributes() {
        List<Integer> attributes = new ArrayList<>();
        for (int i = 0; i < getExample().getAttributes().size(); i++) {
            attributes.add(i);
        }
        return attributes;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Set<T> getKlassifikations() {
        Set<T> set = new HashSet<>();
        data.forEach(d -> {
            set.add(d.getClassification());
        });
        return set;
    }
}
