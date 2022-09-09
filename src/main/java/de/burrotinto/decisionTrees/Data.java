package de.burrotinto.decisionTrees;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@lombok.Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Data {
    private Object classification;
    private List attributes;
}
