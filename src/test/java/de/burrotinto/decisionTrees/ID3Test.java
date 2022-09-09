package de.burrotinto.decisionTrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.burrotinto.decisionTrees.id3.ID3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ID3Test {

    public static List<Data> KINOBESUCH = Arrays.asList(
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
    );

    @Test
    void entropyTestMuenze() {
        List<String> muenze = Arrays.asList("Kopf", "Zahl");
        assertEquals(1.0, ID3.entropyOfList(muenze));
    }

    @Test
    void entropyTestMuenzeUnfair() {
        List<String> muenze = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            muenze.add("Kopf");
        }
        muenze.add("Zahl");
        assertEquals(8, Math.round(ID3.entropyOfList(muenze) * 100));
    }

    @Test
    void attributauswahllUndInformationsgewinnA() {
        assertEquals(9968, Math.round(ID3.entropy(KINOBESUCH) * 10000));
    }

    @Test
    void attributauswahllUndInformationsgewinnB() {
        assertEquals(2964, Math.round(ID3.gain(KINOBESUCH, 9) * 10000));
    }

    @Test
    void attributauswahllUndInformationsgewinnC() {
        assertEquals(635, Math.round(ID3.gain(KINOBESUCH, 6) * 10000));
    }

}

