# Scala Timer Project

![Scala](https://img.shields.io/badge/Scala-3.3.3-red?style=flat-square&logo=scala&logoColor=white)

- This project is a simple yet extensible countdown timer implemented in Scala.
- It primarily consists of two components: a command-line timer that runs on the JVM, and a web-based timer with a user interface that runs in a web browser using Scala.js.

---

## Project Structure

- **The project is configured as an sbt multi-project build.**

- timer-core: A simple command-line countdown timer that runs on the Java Virtual Machine (JVM).
- timer-ui: A web-based countdown timer with a user interface, compiled to JavaScript using Scala.js and running in a web browser.
- project/: Contains sbt build definition files.

---

## Getting Started

- **Follow these steps to set up and run the Scala Timer project.**

#### Prerequisites

- Before you begin, ensure you have the following installed:
  - Java Development Kit (JDK): Version 17 or higher recommended (e.g., OpenJDK).
  - sbt (Scala Build Tool): Version 1.x or higher (e.g., sbt installation guide).
  - Python 3: Used to easily serve the web UI locally (comes pre-installed on most systems).
  - Git: For version control.

## How to Use the Project

```bash
git clone [https://github.com/tamai-hideyuki/scala-timer.git](https://github.com/tamai-hideyuki/scala-timer.git)

cd scala-timer/apps/
```

- sbt の起動

```bash
sbt
```

- Switching to the timerCore project: Inside the sbt console, switch to the timerCore subproject.

```bash
sbt:scala-timer> project timerCore
```

- Running the timer: Execute the timer with the run command. You can specify the number of minutes as an argument (default is 1 minute).
- **To run a 1-minute timer**
```Scala
sbt:timer-core> run
```
- **To run a 3-minute timer:**
```Scala
sbt:timer-core> run 3
```
>Upon execution, a countdown will be displayed in the console and will terminate once the specified time has elapsed.


---

## Running the Web-Based Timer

- The timer-ui project is implemented with Scala.js and runs in a web browser.。

- **Starting sbt:**

- If sbt is not already running, start the sbt console by typing sbt from the root of the scala-timer project.
   ```bash
   sbt
   ```

- **Switching to the timerUI project:**
- Inside the sbt console, switch to the timerUI subproject.
```Scala
sbt:scala-timer> project timerUI
```

- Generating JavaScript files (for development):
- To compile your Scala.js code to JavaScript and automatically recompile on file changes (recommended for development), use the ~fastLinkJS command.

```Scala
sbt:timer-ui> ~fastLinkJS
```
>This command will continue to run in the background, continuously generating timer-ui/target/scala-3.3.3/timer-ui-fastopt.js every time you save your Scala code.

- Starting a local web server:
- To load the generated JavaScript file (timer-ui/target/scala-3.3.3/timer-ui-fastopt.js) in your browser, you'll need a local web server. Open a new terminal window, navigate to the timer-ui directory, and start a web server.

```bash
cd timer-ui
python3 -m http.server 8000 # If you have Python 3 installed
```
>(If you don't have Python 3 installed or prefer a different port, please start a web server using an alternative method, e.g., npm install -g http-server followed by http-server -p 8000.)

- Access in browser:

- **Once the web server is running, access the following URL in your web browser:**
```bash
http://localhost:8000/index.html
```

>The "Scala Timer" UI will be displayed in your browser. Enter your desired duration in minutes and click the "Start Ritual" button to begin the countdown!
