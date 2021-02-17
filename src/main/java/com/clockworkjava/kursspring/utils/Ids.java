package com.clockworkjava.kursspring.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {

    public static int generateNewId(Set<Integer> keysSoFar) {
        if(keysSoFar.isEmpty()){
            return 0;
        }
        else {
//            return keysSoFar.stream().max(Comparator.naturalOrder()).get()+1;
            return keysSoFar.stream().max(Integer::compareTo).get()+1;
        }
    }

}
