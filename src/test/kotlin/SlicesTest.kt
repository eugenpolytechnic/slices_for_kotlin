import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.sbpstu.jblab.slicebleListOf
import ru.sbpstu.jblab.*
import ru.sbpstu.jblab.toSlicebleList

internal class SlicesTest {

    @Test
    fun getFor1Dim() {
        val testList = slicebleListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertEquals(testList[0..6], slicebleListOf(0, 1, 2, 3, 4, 5, 6))
        assertEquals(testList[6..0..-1], slicebleListOf(6, 5, 4, 3, 2, 1, 0))
        assertEquals(testList[1..8..2], slicebleListOf(1, 3, 5, 7))
        assertEquals(testList[7..0..-2], slicebleListOf(7, 5, 3, 1))
        assertEquals(testList[` `..6], slicebleListOf(0, 1, 2, 3, 4, 5, 6))
        assertEquals(testList[3..` `], slicebleListOf(3, 4, 5, 6, 7, 8, 9))
        assertEquals(testList[` `..` `], testList)
        assertEquals(testList[` `..` `..2], slicebleListOf(0, 2, 4, 6, 8))
        assertEquals(testList[-3..` `], slicebleListOf(7, 8, 9))
        assertEquals(testList[-5..` `..-1], slicebleListOf(5, 4, 3, 2, 1, 0))
        assertEquals(testList[-1..3..-2], slicebleListOf(9, 7, 5, 3))
        assertEquals(testList[4..-1..2], slicebleListOf(4, 6, 8))
        assertEquals(testList[-6..-2..1], slicebleListOf(4, 5, 6, 7, 8))
        assertEquals(testList[` `..` `..-1], slicebleListOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
        assertEquals(testList[6..-5], emptyList<Int>().toSlicebleList())
        assertEquals(testList[-6..-1..-1], emptyList<Int>().toSlicebleList())
        assertEquals(testList[3..8..-2], emptyList<Int>().toSlicebleList())
        assertEquals(testList[-2], 8)
        assertEquals(testList[1, 5, 8], slicebleListOf(1, 5, 8))
    }

    @Test
    fun getFor2Dim() {
        val testTable = slicebleListOf(
            slicebleListOf(1, 2, 3, 4),
            slicebleListOf(5, 6, 7, 8),
            slicebleListOf(9, 10, 11, 12),
            slicebleListOf(13, 14, 15, 16)
        )

        assertEquals(testTable[0..2, 0..2],
            slicebleListOf(
                slicebleListOf(1, 2, 3),
                slicebleListOf(5, 6, 7),
                slicebleListOf(9, 10, 11)
            ))

        assertEquals(testTable[1..3, 0..2],
            slicebleListOf(
            slicebleListOf(5, 6, 7),
            slicebleListOf(9, 10, 11),
            slicebleListOf(13, 14, 15)
        ))

        assertEquals(testTable[0..3, 0..1],
            slicebleListOf(
            slicebleListOf(1, 2),
            slicebleListOf(5, 6),
            slicebleListOf(9, 10),
            slicebleListOf(13, 14)
        ))

        assertEquals(testTable[0..3..2, 0..2..1],
            slicebleListOf(
            slicebleListOf(1, 2, 3),
            slicebleListOf(9, 10, 11)
        ))

        assertEquals(testTable[3..0..-1, 0..1..1],
            slicebleListOf(
            slicebleListOf(13, 14),
            slicebleListOf(9, 10),
            slicebleListOf(5, 6),
            slicebleListOf(1, 2)
        ))

        assertEquals(testTable[3..0..-2, 1..0..-1],
            slicebleListOf(
            slicebleListOf(14, 13),
            slicebleListOf(6, 5)
        ))

        assertEquals(testTable[listOf(0, 2, 3, 1, 3), listOf(1, 1, 0, 3, 2)],
            slicebleListOf(2, 10, 13, 8, 15))

        assertEquals(testTable[1..-1..1, 1..0..-1],
            slicebleListOf(
                slicebleListOf(6, 5),
                slicebleListOf(10, 9),
                slicebleListOf(14, 13)
            ))
    }

    @Test
    fun getFor3Dim() {
        val testCube = slicebleListOf(slicebleListOf(
            slicebleListOf(1, 2, 3), slicebleListOf(4, 5, 6), slicebleListOf(7, 8, 9)),
            slicebleListOf(slicebleListOf(10, 11, 12), slicebleListOf(13, 14, 15), slicebleListOf(16, 17, 18)),
            slicebleListOf(slicebleListOf(19, 20, 21), slicebleListOf(22, 23, 24), slicebleListOf(25, 26, 27)))
        assertEquals(testCube[1..2..1, 1..0..-1, 2..` `..-1], slicebleListOf(
            slicebleListOf(slicebleListOf(15, 14, 13), slicebleListOf(12, 11, 10)),
            slicebleListOf(slicebleListOf(24, 23, 22), slicebleListOf(21, 20, 19))))
    }
}

