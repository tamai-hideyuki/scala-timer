package timer

import scala.scalajs.js.timers._
import org.scalajs.dom
import org.scalajs.dom.document

object TimerUI {
  var secondsLeft: Int = 0 // 残り時間
  var currentInterval: Option[SetIntervalHandle] = None // 可変変数だが `null` を排除

  def main(args: Array[String]): Unit = {
    val app = document.getElementById("app")
    if (app == null) {
      dom.console.error("Error: Could not find element with ID 'app'.")
      return
    }

    val input = createInputField()
    val startButton = createButton("Start Ritual", "start-button", startTimer)
    val resetButton = createButton("Reset", "reset-button", resetTimer)
    val output = createOutputDiv()

    app.appendChild(input)
    app.appendChild(startButton)
    app.appendChild(resetButton)
    app.appendChild(output)
  }

  /** 入力フィールドを作成 */
  def createInputField(): dom.html.Input = {
    val input = document.createElement("input").asInstanceOf[dom.html.Input]
    input.placeholder = "Enter minutes"
    input.`type` = "number"
    input.value = "1"
    input
  }

  /** ボタンを作成（イベントリスナー付き） */
  def createButton(text: String, className: String, onClick: dom.Event => Unit): dom.html.Button = {
    val button = document.createElement("button").asInstanceOf[dom.html.Button]
    button.textContent = text
    button.className = className
    button.addEventListener("click", onClick)
    button
  }

  /** 出力用の `div` */
  def createOutputDiv(): dom.html.Div = {
    val output = document.createElement("div").asInstanceOf[dom.html.Div]
    output.textContent = " Ready for ritual."
    output
  }

  /** タイマーを開始 */
  def startTimer(event: dom.Event): Unit = {
    if (currentInterval.isDefined) return // 既存のタイマーが動作中なら何もしない

    val input = document.querySelector("input").asInstanceOf[dom.html.Input]
    val minutes = math.max(input.value.toIntOption.getOrElse(1), 1)
    secondsLeft = minutes * 60

    val output = document.querySelector("div").asInstanceOf[dom.html.Div]
    output.textContent = s" Ritual started: $minutes min"

    if (secondsLeft > 0) {
      currentInterval = Some(setInterval(1000) { countdownStep(output) })
    }
  }

  /** カウントダウン処理 */
  def countdownStep(output: dom.html.Div): Unit = {
    if (secondsLeft > 0) {
      val min = secondsLeft / 60
      val sec = secondsLeft % 60
      output.textContent = f" Remaining: $min%02d:$sec%02d"
      secondsLeft -= 1
    } else {
      output.textContent = " Time's up! Ritual ends."
      currentInterval.foreach(clearInterval)
      currentInterval = None
    }
  }

  /** タイマーをリセット */
  def resetTimer(event: dom.Event): Unit = {
    currentInterval.foreach(clearInterval)
    currentInterval = None
    secondsLeft = 0

    val input = document.querySelector("input").asInstanceOf[dom.html.Input]
    val output = document.querySelector("div").asInstanceOf[dom.html.Div]

    input.value = ""
    output.textContent = " Timer reset. Ready for ritual."
  }
}
