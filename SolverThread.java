import java.util.HashSet;

public class SolverThread extends Thread{
    private int xpos;
    private int ypos;
    private int sudoku[][];
    private HashSet<Integer> state;
    SolverThread(int[][] sudoku,int xpos,int ypos) {
        this.xpos=xpos;
        this.ypos=ypos;
        this.sudoku=sudoku;
        this.state=new HashSet<>();
        for(int i=1;i<=9;i++) {
            this.state.add(i);
        }
    }
    public void run() {
        // get access to this.sudoku

        // start vaidations and update the state

        // check if state is solved (if one element exists)

        // if solved quit the thread

        // else wait
    }
    
    private void check() {
        this.validateRow();
        this.validateColumn();
        this.validateGrid();
    }
    private void validateRow() {
        
    }
    private void validateColumn() {
        
    }
    private void validateGrid() {
        
    }

}