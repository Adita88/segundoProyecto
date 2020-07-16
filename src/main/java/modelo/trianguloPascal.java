package modelo;


public class trianguloPascal {

    
    protected static final int[][] PASCAL_MATRIZ= inicilizarConCombinatoria();
    protected final static int DIMENSION_MAXIMA_MATRIZ=10;
    protected static ColoresRGB color[][];
    protected static int cantFilasMostrables;
    


    public trianguloPascal() {
        trianguloPascal.color= new ColoresRGB[DIMENSION_MAXIMA_MATRIZ][DIMENSION_MAXIMA_MATRIZ];
        trianguloPascal.cantFilasMostrables=DIMENSION_MAXIMA_MATRIZ;
        
        pascalEstadoInicial();
        inicilizarConCombinatoria();
    }
    
    /**
     * Método define la cantidad de filas que se deben mostrar
     * @param cantFilasMostrables valor que indica la cantidad de fila que se van a mostrar
     */
    public trianguloPascal(int cantFilasMostrables) {
        trianguloPascal.color= new ColoresRGB[DIMENSION_MAXIMA_MATRIZ][DIMENSION_MAXIMA_MATRIZ];
        if(cantFilasMostrables<=0 || cantFilasMostrables>DIMENSION_MAXIMA_MATRIZ) {
            trianguloPascal.cantFilasMostrables=DIMENSION_MAXIMA_MATRIZ;
        } else {
            trianguloPascal.cantFilasMostrables= cantFilasMostrables;
        }
        pascalEstadoInicial();
        inicilizarConCombinatoria();
    }
    
    /**
     * Método para iniciar
     * @return 
     */
    private static int[][] inicilizarConCombinatoria(){
        int array[][]= new int[DIMENSION_MAXIMA_MATRIZ][DIMENSION_MAXIMA_MATRIZ];
        for(int fila=0; fila<DIMENSION_MAXIMA_MATRIZ; fila++){
            for(int columna=0; columna<fila+1; columna++){
                array[fila][columna]=factorial(fila)/ (factorial(columna)*factorial(fila-columna));
            }
        }
        return array;
    }
    
    /**
     * Método establece a Pascal como estado inicial
     */
    public static void pascalEstadoInicial(){
        for(int fila=0; fila<DIMENSION_MAXIMA_MATRIZ; fila++)
            for(int columna=0; columna<DIMENSION_MAXIMA_MATRIZ; columna++)
                trianguloPascal.color[fila][columna]=ColoresRGB.colorBase;
    }
    
    /**
     * Método con formula factorial
     * @param num Valor a conseguir el factorial
     * @return 
     */
    private static int factorial(int num){
        if(num == 0){
            return 1;
        }
        else
            return num * factorial(num-1);
    }
    
    /**
     * Método dibuja el triángulo
     */
    public static void dibujarTriangulo() {
        
        
        for(int fila=0; fila<DIMENSION_MAXIMA_MATRIZ; fila++)
            for(int columna=0; columna<DIMENSION_MAXIMA_MATRIZ; columna++)
                trianguloPascal.color[fila][columna]=ColoresRGB.colorBase;
    }
    
    /**
     * Método get Pascal_Matriz
     * @return 
     */
    public int[][] getPASCAL_MATRIZ() {
        return PASCAL_MATRIZ;
    }

    public int getCantFilasMostrables() {
        return cantFilasMostrables;
    }

    /**
     * Método que establece el rango de filas
     * @param cantFilasMostrables cantidad de filas
     * @throws RuntimeException 
     */
    public void setCantFilasMostrables(int cantFilasMostrables) throws RuntimeException {
        if(cantFilasMostrables<=0 || cantFilasMostrables>DIMENSION_MAXIMA_MATRIZ) throw new RuntimeException();
        trianguloPascal.cantFilasMostrables = cantFilasMostrables;
    }
    
    public static int getDIMENSION_MAXIMA_MATRIZ() {
        return DIMENSION_MAXIMA_MATRIZ;
    }

    public static ColoresRGB[][] getColor() {
        return color;
    }

    /**
     * Método que establece el color 
     * @param color color a establecer
     */
    public static void setColor(ColoresRGB[][] color) {
        trianguloPascal.color = color;
    }


    
    @Override
    public String toString() {
        String valoresString="";
        for(int i=0; i<DIMENSION_MAXIMA_MATRIZ;i++){
            for(int j=0; j<DIMENSION_MAXIMA_MATRIZ;j++){
                valoresString+= (PASCAL_MATRIZ[i][j]+", ");
            }
            valoresString+="\n";
        }
        
        String coloresString="";
        for(int i=0; i<DIMENSION_MAXIMA_MATRIZ;i++){
            for(int j=0; j<DIMENSION_MAXIMA_MATRIZ;j++){
                coloresString+= (color[i][j]+", ");
            }
            coloresString+="\n";
        }
        return "trianguloPascal{" +
                "\nDIMENSION_MAXIMA_MATRIZ= "+ DIMENSION_MAXIMA_MATRIZ
                +",\ncantFilasMostrables= " + cantFilasMostrables
                + ",\nPASCAL_MATRIZ=\n" + valoresString
                + ",\ncolores=\n" + coloresString
                + "}";
    }
    
    
    
}
