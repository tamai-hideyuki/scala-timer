package timer

object TimerApp {
  def main(args: Array[String]): Unit = {
    // 引数が与えられていない場合は60秒をデフォルトとし、
    // 与えられた場合はその分数を秒に換算。
    val initialMinutes: Int = if (args.length > 0) args(0).toIntOption.getOrElse(1) else 1
    val totalSeconds: Int = initialMinutes * 60

    println(s"Ritual begins: ${initialMinutes} minutes (${totalSeconds} seconds)")

    // 秒単位でカウントダウンするループ
    for (i <- totalSeconds to 1 by -1) {
      // 残り秒数を表示
      println(s" ${i} second(s) remaining...")
      // 1秒待機
      Thread.sleep(1 * 1000) // 1000ミリ秒 = 1秒
    }

    println(" Time's up! End of ritual.")
  }
}


