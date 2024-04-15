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
        for (int i = 0; i < 9; i++) {
            if(this.ypos!=i && this.sudoku[this.xpos][i] != 0) {
                this.state.remove(this.sudoku[this.xpos][i]);
            }
        }
    }

    private void validateColumn() {
        for (int i = 0; i < 9; i++) {
            if(this.xpos!=i && this.sudoku[i][this.ypos] != 0) {
                this.state.remove(this.sudoku[i][this.ypos]);
            }
        }
    }

    private void validateGrid() {
        int si = (this.xpos / 3) * 3;
        int sj = (this.ypos / 3) * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(this.xpos==si+i && this.ypos==sj+j) && this.sudoku[si+i][sj+j] != 0) {
                    this.state.remove(this.sudoku[si+i][sj+j]);
                }
            }
        }
    }
}