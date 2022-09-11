package de.burrotinto.decisionTrees.id3;

import de.burrotinto.MathHelper;
import de.burrotinto.decisionTrees.Data;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ID3 {

    protected final List<Data> data;
    protected Optional<Double> entropy = Optional.empty();

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


    public double entropy() {
        if (entropy.isEmpty()) {
            entropy = Optional.of(entropyOfList(data.stream().map(Data::getClassification).collect(Collectors.toList())));
        }
        return entropy.get();
    }

    //Todo
    public double gain(int knownAttribut) {
        double entropy = entropy();

        Map<Object, List<Data>> known = data.stream().collect(Collectors.groupingBy(d -> d.getAttributes().get(knownAttribut)));

        entropy -= known.values().stream().mapToDouble(d -> (((double) d.size()) / data.size()) * new ID3(d).entropy()).sum();

        return entropy;
    }

    public int chooseAttribute(List<Integer> attributes) {

        int bestAttribute = 0;
        double maxEntropy = 0;

        val it = attributes.iterator();
        var next = 0;
        while (it.hasNext()) {
            next = it.next();
            double e = gain(next);

            if (e > maxEntropy) {
                maxEntropy = e;
                bestAttribute = next;
            }
        }
        return bestAttribute;
    }
}

