#  scala-timer

- **scala-timer** is a lightweight and extendable countdown timer built with Scala.  
- It supports both a **command-line interface (JVM)** and a **web-based interface (Scala.js)** with a real-time countdown display.
- A timer designed to support focused work sessions, study periods, or productivity routines (e.g., Pomodoro Technique).

---

##  Features

-  Command-line countdown timer built with Scala (JVM-based)
-  Interactive Web UI powered by Scala.js (with real-time countdown)
-  No backend required — works fully in-browser
-  Easy to build using sbt
-  Minimal external dependencies

---

##  Project Structure

| Directory      | Description                          |
|----------------|--------------------------------------|
| `timer-core/`  | Core CLI logic (Scala/JVM)           |
| `timer-ui/`    | Web UI powered by Scala.js           |
| `project/`     | Shared sbt project settings          |
| `README.md`    | You are reading it right now         |

---


##  Getting Started

### 1. Run the CLI Timer (JVM)

```bash
cd timer-core

sbt run -- 5
```

```text
→ Starts a 5-minute countdown in your terminal.
```

## Run the Web Timer (Scala.js)

```bash
cd timer-ui

sbt fastLinkJS
```

- **Then open the following HTML file in your browser:**

```html
<!-- timer-ui/index.html example -->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Scala Timer</title>
  <script type="text/javascript" src="target/scala-3.x/timer-ui-fastopt.js"></script>
</head>
<body>
  <h1> Scala Timer</h1>
  <div id="app"></div>
</body>
</html>
```

## Build Instructions

- **Build the Web UI (Scala.js)**

```bash
cd timer-ui

sbt fastLinkJS
```

- **Build the CLI app (JVM)**

```bash
cd timer-core

sbt run
```

## Technologies Used

- Scala 3.x
- Scala.js
- sbt (Scala Build Tool)
- HTML5 + JavaScript


## Planned Enhancements

-  Notification sound upon timer completion
-  Preset time buttons
-  Mobile-friendly & PWA support
-  Manage multiple timers simultaneously
-  Logging and focus statistics


## Final Words

>Time is the most powerful magic.
With scala-timer, you can now shape it to your will — whether in the console or your browser.

