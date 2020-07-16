/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David B
 */
public enum ColoresRGB {
    color0, color1, color2,
    color3, color4, color5,
    color6, color7, color8,
    color9, color10, color11,
    color12, color13, color14,
    color15,color16, colorBase;
    
    
    public static ColoresRGB getColorRGB(int numero){
        switch(numero){
            case -1: return colorBase;
            case 0: return color0;
            case 1: return color1;
            case 2: return color2;
            case 3: return color3;
            case 4: return color4;
            case 5: return color5;
            case 6: return color6;
            case 7: return color7;
            case 8: return color8;
            case 9: return color9;
            case 10: return color10;
            case 11: return color11;
            case 12: return color12;
            case 13: return color13;
            case 14: return color14;
            case 15: return color15;
            case 16: return color16;
        }
        return null;
    }
    
    public static int[] getCodigoColor(ColoresRGB color){
        switch(color){
            case colorBase: return new int[]{43, 45, 66};
            case color0: return new int[]{32, 58, 68};
            case color1: return new int[]{42, 157, 143};
            case color2: return new int[]{90, 167, 134};
            case color3: return new int[]{138, 177, 125};
            case color4: return new int[]{233, 196, 106};
            case color5: return new int[]{239, 179, 102};
            case color6: return new int[]{239, 179, 102};
            case color7: return new int[]{238, 137, 89};
            case color8: return new int[]{231, 111, 81};
            case color9: return new int[]{239, 157, 136};

            case color10: return new int[]{183, 68, 184};
            case color11: return new int[]{168, 32, 26};
            case color12: return new int[]{91, 192, 235};
            case color13: return new int[]{155, 197, 61};
            case color14: return new int[]{50, 10, 40};
            case color15: return new int[]{142, 68, 61};
            case color16: return new int[]{255, 188, 181};
        }
        return null;
    }
    
    public static int[] getCodigoColor(int numero){
        switch(numero){
            case -1: return new int[]{43, 45, 66};
            case 0: return new int[]{32, 58, 68};
            case 1: return new int[]{42, 157, 143};
            case 2: return new int[]{90, 167, 134};
            case 3: return new int[]{138, 177, 125};
            case 4: return new int[]{233, 196, 106};
            case 5: return new int[]{239, 179, 102};
            case 6: return new int[]{239, 179, 102};
            case 7: return new int[]{238, 137, 89};
            case 8: return new int[]{231, 111, 81};
            case 9: return new int[]{239, 157, 136};

            case 10: return new int[]{183, 68, 184};
            case 11: return new int[]{168, 32, 26};
            case 12: return new int[]{91, 192, 235};
            case 13: return new int[]{155, 197, 61};
            case 14: return new int[]{50, 10, 40};
            case 15: return new int[]{142, 68, 61};
            case 16: return new int[]{255, 188, 181};
        }
        return null;
    }
}
