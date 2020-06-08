package org.jetbrains.calculator.utils;

import java.util.HashSet;
import java.util.Set;

public final class Utils {
    public static final Set<Character> operationsSet = new HashSet() {{
        add('+');
        add('-');
        add('*');
        add('/');
    }};
}
