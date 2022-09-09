package de.burrotinto.decisionTrees.id3;

import de.burrotinto.MathHelper;
import de.burrotinto.decisionTrees.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ID3 {

    /**
     * @param list
     * @return
     */
    public static double entropyOfList(List list) {
        Map<Object, AtomicInteger> map = new HashMap<>();
        list.forEach(o -> {
            map.putIfAbsent(o, new AtomicInteger());
            map.get(o).incrementAndGet();
        });

        AtomicReference<Double> e = new AtomicReference<>((double) 0);

        map.forEach((key, value) -> {
            double x = ((double) value.get()) / list.size();
            e.set(e.get() - x * MathHelper.customLog(2, x));
        });

        return e.get();
    }


    public static double entropy(List<Data> data) {
        return entropyOfList(data.stream().map(Data::getClassification).collect(Collectors.toList()));
    }

    //Todo
    public static double gain(List<Data> data, int knownAttribut) {
        double entropy = entropy(data);

        Map<Object, List<Data>> known = data.stream().collect(Collectors.groupingBy(d -> {
            return d.getAttributes().get(knownAttribut);
        }));


        entropy -= known.values().stream().mapToDouble(d -> {
            return (((double) d.size()) / data.size()) * entropy(d);
        }).sum();


        return entropy;
    }
}
