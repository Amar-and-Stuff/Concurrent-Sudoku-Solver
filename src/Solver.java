import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Solver {
    private int[][] sudoku;
    private ArrayList<SolverThread> solverThreads;

    Solver(int[][] sudoku) {
        this.sudoku = sudoku;
        this.solverThreads = new ArrayList<>();
        this.initilizeThreads();
        this.startVisualization();
    }

    private void initilizeThreads() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.sudoku[i][j] == 0)
                    this.solverThreads.add(new SolverThread(this.sudoku, i, j));
            }
        }
        this.solverThreads.forEach(i -> i.start());
    }

    private void startVisualization() {
        int itr = 0;
        while (this.solverThreads.stream().anyMatch(i -> i.isAlive())) {
            // clear the screen
            try {
                boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
                ProcessBuilder processBuilder;
                if (!isWindows)
                    processBuilder = new ProcessBuilder("clear");
                else
                    processBuilder = new ProcessBuilder("cls");
                Process process = processBuilder.inheritIO().start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Iteration: " + itr++);
            // print sudoku
            System.out.println(this.toString());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner outerJoiner = new StringJoiner("\n");
        for (int i = 0; i < this.sudoku.length; i++) {
            StringJoiner innerJoiner = new StringJoiner(" ");
            for (int j = 0; j < this.sudoku[i].length; j++) {
                innerJoiner.add(String.valueOf(this.sudoku[i][j]));
            }
            outerJoiner.add(innerJoiner.toString());
        }
        return outerJoiner.toString() + "\n" + this.solverThreads;
    }
}