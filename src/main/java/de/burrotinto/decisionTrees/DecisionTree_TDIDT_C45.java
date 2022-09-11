package de.burrotinto.decisionTrees;

import de.burrotinto.decisionTrees.id3.C4_5;
import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class DecisionTree_TDIDT_C45<T> {

    private List<T> decision = null;
    private final Map<Object, DecisionTree_TDIDT_C45> childs = new HashMap<>();

    private int chosenAttribute = -1;

    private List<String> attributNames;

    public DecisionTree_TDIDT_C45(DataSet<T> data) {
        this(data, data.getNumberOfAllAttributes());
    }


    public DecisionTree_TDIDT_C45(DataSet<T> data, List<Integer> attributes) {
        attributNames = data.getAttributeNames();
        C4_5 lernsystem = new C4_5(data);

        if (data.isEmpty()) {
            //DEFAULT RÜCKGABE
            decision = Collections.emptyList();
        } else if (data.getKlassifikations().size() == 1) {
            // Alle Elemente haben die gleiche Klassifikation
            decision = data.getKlassifikations().stream().toList();
        } else if (attributes.isEmpty()) {
            //gleiche Beispiele mit unterschiedlicher Klassisikation
            decision = data.getKlassifikations().stream().toList();
        } else {

            chosenAttribute = lernsystem.chooseAttribute(attributes);
            List<Integer> remainingAttributes = new ArrayList<>(attributes);
            remainingAttributes.remove((Integer) chosenAttribute);

            val group = data.getData().stream().collect(Collectors.groupingBy(d -> d.getAttribut(chosenAttribute)));

                group.forEach((key, d) -> {
                    childs.put(key, new DecisionTree_TDIDT_C45<T>(new DataSet<>(d, data.getAttributeNames()), remainingAttributes));
                });
        }
    }


    public List<T> getDecision(Data<T> data) {
        if (childs.isEmpty()) {
            return decision;
        } else {
            return childs.get(data.getAttribut(chosenAttribute)).getDecision(data);
        }
    }


    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        if (decision != null) {
            buffer.append(decision);
        } else if(!attributNames.isEmpty()) {
            buffer.append(attributNames.get(chosenAttribute));
        }
        buffer.append('\n');
        for (Iterator<Map.Entry<Object, DecisionTree_TDIDT_C45>> it = childs.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Object, DecisionTree_TDIDT_C45> next = it.next();
            if (it.hasNext()) {
                next.getValue().print(buffer, childrenPrefix + "├─{"+next.getKey() + "}─>", childrenPrefix + "│     ");
            } else {
                next.getValue().print(buffer, childrenPrefix + "└─{"+next.getKey()+ "}─>", childrenPrefix + "      ");
            }
        }
    }
}
