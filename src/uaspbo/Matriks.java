package uaspbo;

public class Matriks {
    private Integer row;
    private Integer col;
    private int[][] matriks;
    private int[][] matriksN;
    private int[] vektor;
    private int[] vektorSortIndex;
    
    public Matriks(int row, int col){
        this.row = row;
        this.col = col;
        matriks = new int[row][col];
    }    
    
    public int[][] getMatriksN(int colProc){
        colProc = colProc-1;
        this.matriksN = new int[this.row][this.col];
        this.vektor = new int[this.row];
        this.vektorSortIndex = new int[this.row];
        for(int i=0;i<this.row;i++){
            this.vektor[i]=this.matriks[i][colProc];
            this.vektorSortIndex[i]=i;
        }    
        urutVektor();
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                this.matriksN[i][j] = this.matriks[this.vektorSortIndex[i]][j];
            }            
        }    
        return this.matriksN;
    }    
    
    private void urutVektor(){
        int tempVal;
        for(int i=0;i<this.row-1;i++){
            for(int j=i;j<this.row;j++){
                if(this.vektor[i]>this.vektor[j]){
                    tempVal = this.vektor[i];
                    this.vektor[i]=this.vektor[j];
                    this.vektor[j]=tempVal;
                    tempVal = this.vektorSortIndex[i];
                    this.vektorSortIndex[i]=this.vektorSortIndex[j];
                    this.vektorSortIndex[j]=tempVal;                    
                }    
            }    
        }                    
    }
    
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public int[][] getMatriks() {
        return matriks;
    }

    public void setMatriks(int[][] matriks) {
        this.matriks = matriks;
    }
    
    public int getMatrks(int row, int col){
            return matriks[row][col];
    }        

    public void setMatriks(int row, int col, int val) {
        this.matriks[row][col] = val;
    }        
    
}
