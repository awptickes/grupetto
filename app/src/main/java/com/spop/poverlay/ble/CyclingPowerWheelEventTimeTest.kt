package com.spop.poverlay.ble

//adaption of tjbbjt's proposed CyclingPowerWheelEventTimeTest.kt to not use JUnit.

private fun assertEquals(expected: Int, actual: Int) =
    check(expected == actual) { "Expected <$expected> but was <$actual>" }

fun main() {
    assertEquals(0, cyclingPowerWheelEventTime(0))
    assertEquals(2048, cyclingPowerWheelEventTime(1024))
    assertEquals(1000, cyclingPowerWheelEventTime(500))

    assertEquals(0, cyclingPowerWheelEventTime(32768))
    assertEquals(65534, cyclingPowerWheelEventTime(65535))

    val before = cyclingPowerWheelEventTime(65530)
    val after = cyclingPowerWheelEventTime((65530 + 20) and 0xFFFF)
    assertEquals(40, (after - before) and 0xFFFF)

    println("All tests passed")
}