import java.util.HashSet;

public class SolverThread extends Thread{
    private int xpos;
    private int ypos;
    private int sudoku[][];
    private HashSet<Integer> hs;
    SolverThread(int[][] sudoku,int xpos,int ypos) {
        this.xpos=xpos;
        this.ypos=ypos;
        this.sudoku=sudoku;
        hs=new HashSet<>();
        for(int i=1;i<=9;i++) {
            hs.add(i);
        }
    }
    public void run() {
        
    }
    public void check() {
        validateRow();
        validateColumn();
        validateMatrix();
    }
    public void validateRow() {
        
    }
    public void validateColumn() {
        
    }
    public void validateMatrix() {
        
    }

}