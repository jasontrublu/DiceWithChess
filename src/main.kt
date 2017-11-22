import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableElement
import kotlin.browser.document
import kotlin.dom.addClass

fun main(args: Array<String>) {
    println("Hello JavaScript!")
    val board = document.getElementById("board") as HTMLTableElement
    val cells = CellContainer()
    for (i in 1..9) {
        val row = board.insertRow()
        row.id = "row$i"
        for (j in 1..9) {
            val cell = row.insertCell() as HTMLTableCellElement
            cells[i, j] =cell
            cell.id = "field$i$j"
            cell.addClass("field")
        }
    }
    (document.getElementById("field33") as HTMLTableCellElement).innerHTML = "6"
}

inline fun <reified INNER> array2d(sizeOuter: Int, sizeInner: Int, noinline innerInit: (Int) -> INNER): Array<Array<INNER>>
        = Array(sizeOuter) { Array(sizeInner, innerInit) }

class CellContainer {
    val cells = array2d<HTMLTableCellElement?>(9, 9) { null }

    operator fun set(i: Int, j: Int, cell: HTMLTableCellElement) {
        cells[i - 1][j - 1] = cell
    }

}
