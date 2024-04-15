public class SolverThread extends Thread{
    private int xpos;
    private int ypos;
    private int sudoku[][]=new int[9][9];
    SolverThread(int sudoku,int xpos,int ypos) {
        this.xpos=xpos;
        this.ypos=ypos;
        this.sudoku=sudoku;
    }
    public void run() {
        
    }

}