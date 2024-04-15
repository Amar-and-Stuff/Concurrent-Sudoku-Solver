import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
        for(int i =0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this.sudoku[i][j]==0) this.solverThreads.add(new SolverThread(this.sudoku, i, j));
            } 
        }
        this.solverThreads.forEach(i->i.start());
    }

    private void startVisualization() {
        while(this.solverThreads.stream().anyMatch(i->i.isAlive())) {
            // clear the screen
            try {
                boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
                ProcessBuilder processBuilder;
                if(!isWindows)
                processBuilder = new ProcessBuilder("clear");
                else
                processBuilder = new ProcessBuilder("cls");
                Process process = processBuilder.inheritIO().start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

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
        return Arrays.toString(sudoku); // + ", solverThreads=" + solverThreads + "]";
    }
}