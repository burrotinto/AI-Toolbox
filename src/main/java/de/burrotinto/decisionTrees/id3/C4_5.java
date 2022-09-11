package de.burrotinto.decisionTrees.id3;

import de.burrotinto.decisionTrees.Data;
import de.burrotinto.decisionTrees.DataSet;
import de.burrotinto.decisionTrees.id3.ID3;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class C4_5 extends ID3 {
    public C4_5(List<Data> data) {
        super(data);
    }

    public C4_5(DataSet data) {
        this(data.getData());
    }

    public double splitInfo(int attribute) {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getAttribut(attribute));
        }

        return ID3.entropyOfList(list);
    }

    public double gainRatio(int attribute) {
        return gain(attribute) / splitInfo(attribute);
    }

    @Override
    public int chooseAttribute(List<Integer> attributes) {


        int bestAttribute = attributes.stream().findFirst().get();
        double maxEntropy = Double.NEGATIVE_INFINITY;


        for (int i = 0; i < attributes.size(); i++) {
            Integer next = attributes.get(i);
            if (splitInfo(next) != 0.0) {
                double e = gainRatio(next);

                if (e > maxEntropy) {
                    maxEntropy = e;
                    bestAttribute = attributes.get(i);
                }
            }
        }
        return bestAttribute;
    }

}
