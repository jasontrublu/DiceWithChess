import org.w3c.dom.HTMLTableCellElement
import kotlin.browser.document

fun main(args: Array<String>) {
    println("Hello JavaScript!")
    (document.getElementById("field33") as HTMLTableCellElement).innerHTML = "6"
}
