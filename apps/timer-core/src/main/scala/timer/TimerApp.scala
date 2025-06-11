package timer

object TimerApp {
  def main(args: Array[String]): Unit = {
    val minutes: Int =
      if (args.length > 0) args(0).toIntOption.getOrElse(1)
      else 1

    println(s"‍♂️ Ritual begins: $minutes minutes")

    for (i <- minutes to 1 by -1) {
      println(s" $i minute(s) remaining...")
      Thread.sleep(60 * 1000)
    }

    println(" Time's up! End of ritual.")
  }
}


