package de.burrotinto.decisionTrees.kurven;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class WindowList<T> {
    private final List<T> orginalList;


    public List<List<T>>getWindows(int windowsize){
        List<List<T>> list = new ArrayList<>();
        for (int i = 0; i < orginalList.size(); i+=windowsize) {
            list.add(orginalList.subList(i,i+windowsize));
        }
        return list;
    }

    public List<List<T>>getMovingWindows(int windowsize){
        List<List<T>> list = new ArrayList<>();
        for (int i = 0; i < orginalList.size()-windowsize; i++) {
            list.add(orginalList.subList(i,i+windowsize));
        }
        return list;
    }
}
