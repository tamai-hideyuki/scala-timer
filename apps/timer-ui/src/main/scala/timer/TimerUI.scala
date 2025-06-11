package timer

import scala.scalajs.js.timers._
import org.scalajs.dom
import org.scalajs.dom.document

object TimerUI {
  def main(args: Array[String]): Unit = {
    val app = document.getElementById("app")
    val input = document.createElement("input").asInstanceOf[dom.html.Input]
    input.placeholder = "Enter minutes"
    input. = "number"

    val button = document.createElement("button")
    button.textContent = "Start Ritual"

    val output = document.createElement("div")

    button.addEventListener("click", { (_: dom.Event) =>
      val minutes = input.value.toIntOption.getOrElse(1)
      var secondsLeft = minutes * 60
      output.textContent = s" Ritual started: $minutes min"

      setInterval(1000) {
        if (secondsLeft > 0) {
          val min = secondsLeft / 60
          val sec = secondsLeft % 60
          output.textContent = f" Remaining: $min%02d:$sec%02d"
          secondsLeft -= 1
        } else {
          output.textContent = " Time's up! Ritual ends."
        }
      }
    })

    app.appendChild(input)
    app.appendChild(button)
    app.appendChild(output)
  }
}
