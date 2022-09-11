package de.burrotinto.decisionTrees;


import de.burrotinto.decisionTrees.id3.C4_5;
import de.burrotinto.decisionTrees.id3.ID3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C4_5Test {

    public static final List<Data> KINOBESUCH = ID3Test.KINOBESUCH;

    public static final DataSet<String> RATE_MAL = new DataSet<>(Arrays.asList(
            new RateMalData("Elaine", true, true, false, false, true, false, false,true),
            new RateMalData("Alice", true, true, false, false, true, false, false, false)
    ),Arrays.asList("Weiblich","Brille","Hut","Ohrring","Haarreif","Bart", "Brünett","Blond"));

    @Test
    void splitInfoTestAttraktivitaet(){
        assertEquals(13383, Math.round(new C4_5(KINOBESUCH).splitInfo( 0) * 10000));
    }
    @Test
    void splitInfoTestWetter(){
        assertEquals(15656, Math.round(new C4_5(KINOBESUCH).splitInfo( 3) * 10000));
    }
    @Test
    void splitInfoTestGruppe(){
        assertEquals(15058, Math.round(new C4_5(KINOBESUCH).splitInfo( 9) * 10000));
    }

    @Test
    void gainRatioTestAttraktivitaet(){
        assertEquals(1388, Math.round(new C4_5(KINOBESUCH).gainRatio( 0) * 10000));
    }
    @Test
    void gainRatioTestWetter(){
        assertEquals(893, Math.round(new C4_5(KINOBESUCH).gainRatio( 3) * 10000));
    }
    @Test
    void gainRatioTestGruppe(){
        assertEquals(1968, Math.round(new C4_5(KINOBESUCH).gainRatio( 9) * 10000));
    }
    @Test
    void chooseAttributeTest(){
        assertEquals(9,new C4_5(KINOBESUCH).chooseAttribute(Arrays.asList(0,1,2,3,4,5,6,7,8,9)));
    }

    @Test
    void aliceUedElaine(){
            assertEquals(7,new C4_5(RATE_MAL).chooseAttribute(Arrays.asList(0,2,3,5,6,7)));
    }
}
