package de.burrotinto.decisionTrees;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@lombok.Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Data<T> {
    private T classification;
    private List attributes;

    public Object getAttribut(int attribut){
        return getAttributes().get(attribut);
    }
}
