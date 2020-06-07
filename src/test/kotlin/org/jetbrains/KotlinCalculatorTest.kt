package org.jetbrains

import org.junit.Assert.assertEquals
import org.junit.Test

class KotlinCalculatorTest {
    @Test fun simpleTest() {
        assertEquals("simple addition", 2.0, evaluate("1 + 1"), 1e-4)
    }
}