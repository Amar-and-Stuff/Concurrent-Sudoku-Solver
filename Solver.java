import java.util.ArrayList;

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
            // print sudoku
        }
    }

}