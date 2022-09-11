package de.burrotinto.decisionTrees;

import java.util.Arrays;

public class RateMalData extends Data {
    public RateMalData(String name, boolean weiblich, boolean brille, boolean hut, boolean ohrring, boolean harreif, boolean bart,boolean brauneHaare,boolean blondeHaare) {
        super(name, Arrays.asList(weiblich, brille, hut, ohrring, harreif, bart,brauneHaare,blondeHaare));
    }
}
