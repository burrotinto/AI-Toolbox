package de.burrotinto.decisionTrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.burrotinto.decisionTrees.id3.C4_5;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TDIDTTest {

    public static final DataSet<String> RATE_MAL = new DataSet<>(Arrays.asList(
            new RateMalData("Roger", false, false, true, false, false, true, true, false),
            new RateMalData("James", false, true, false, false, false, false, false,true),
            new RateMalData("Tom", false, false, true, false, false, false, false, false),
            new RateMalData("Basil", false, true, false, false, false, false, false, false),
            new RateMalData("Joet", true, false, true, false, false, false, true, false),
            new RateMalData("David", false, false, true, false, false, false, false, false),
            new RateMalData("Doris", true, true, false, true, false, false, true, false),
            new RateMalData("EVE", true, false, true, false, false, false, false, false),
            new RateMalData("Mary", true, true, false, true, false, false, false, false),
            new RateMalData("Patrick", false, false, false, true, false, true, false, false),
            new RateMalData("Anita", true, false, true, true, false, false, false, false),
            new RateMalData("Elaine", true, true, false, false, true, false, false,true),
            new RateMalData("Philip", false, false, false, false, false, false, false,true),
            new RateMalData("Tony", false, false, false, false, false, true, false, false),
            new RateMalData("Emily", true, true, true, false, false, false, false, false),
            new RateMalData("Loisa", true, true, false, false, false, false, false,true),
            new RateMalData("Joan", true, false, false, true, false, false, false, false),
            new RateMalData("Zita", true, false, false, false, true, false, false,true),
            new RateMalData("Ronald", false, false, false, false, false, false, false, false),
            new RateMalData("Alice", true, true, false, false, true, false, false, false),
            new RateMalData("Joyce", true, false, false, false, false, false, true, false),
            new RateMalData("Eric", false, false, false, false, false, true, false, false),
            new RateMalData("Albert", false, true, false, false, false, false, false, false),
            new RateMalData("Bruce", false, true, false, false, false, false, true, false)
    ),Arrays.asList("Weiblich","Brille","Hut","Ohrring","Haarreif","Bart", "Brünett","Blond"));


    public static final DataSet<String> KINOBESUCH = new DataSet<>(Arrays.asList(
            new Data(true, Arrays.asList("hoch", "€€", true, "schlecht", true, "top", "AC", "int", true, "Freunde")),
            new Data(true, Arrays.asList("mittel", "€", true, "mittel", false, "mittel", "KO", "int", false, "Paar")),
            new Data(false, Arrays.asList("mittel", "€", false, "mittel", true, "mittel", "DR", "int", false, "Freunde")),
            new Data(false, Arrays.asList("gering", "€", true, "mittel", true, "mittel", "SF", "int", false, "allein")),
            new Data(true, Arrays.asList("mittel", "€", true, "mittel", false, "mittel", "DR", "int", false, "Paar")),
            new Data(true, Arrays.asList("hoch", "€€", true, "schön", false, "top", "SF", "int", true, "Freunde")),
            new Data(true, Arrays.asList("mittel", "€", true, "schlecht", false, "mittel", "KO", "nat", false, "Freunde")),
            new Data(true, Arrays.asList("mittel", "€", false, "schlecht", true, "mittel", "AC", "int", false, "Freunde")),
            new Data(false, Arrays.asList("gering", "€", true, "schön", false, "mittel", "KO", "nat", false, "Freunde")),
            new Data(false, Arrays.asList("mittel", "€", true, "schön", false, "mittel", "KO", "int", false, "Paar")),
            new Data(true, Arrays.asList("hoch", "€", true, "mittel", true, "top", "DR", "int", false, "Paar")),
            new Data(false, Arrays.asList("mittel", "€", false, "schlecht", true, "mittel", "AC", "nat", false, "allein")),
            new Data(false, Arrays.asList("hoch", "€€", true, "mittel", true, "mittel", "SF", "int", false, "allein")),
            new Data(false, Arrays.asList("mittel", "€", true, "schön", true, "top", "DR", "int", true, "Freunde")),
            new Data(true, Arrays.asList("mittel", "€", true, "schlecht", false, "mittel", "AC", "int", false, "Paar"))
    ));

    @Test
    void rateMalTest() {
        DecisionTree_TDIDT_C45 tree = new DecisionTree_TDIDT_C45(RATE_MAL);
        System.out.printf("");
    }

    @Test
    void printTest(){
        DecisionTree_TDIDT_C45 tree = new DecisionTree_TDIDT_C45(RATE_MAL);
        System.out.println(tree.toString());
    }
    @Test
    void printTest2(){
        DecisionTree_TDIDT_C45 tree = new DecisionTree_TDIDT_C45(KINOBESUCH);
        System.out.println(tree.toString());
    }

}
