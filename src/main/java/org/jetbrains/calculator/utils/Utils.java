package org.jetbrains.calculator.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Utils {

    private Utils() {
    }

    public static final Set<Character> operationsSet = new HashSet(Arrays.asList('+', '-', '*', '/'));

}
