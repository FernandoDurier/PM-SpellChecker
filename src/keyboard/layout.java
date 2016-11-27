/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

/**
 *
 * @author Cliente
 */
public class layout {

    private String tipo;
    private String line1;
    private String line2;
    private String line3;
    private double offset1 = 0;
    private double offset2;
    private double offset3;
    private double[][] matrizDistancias;

    public layout() {
    }

    public layout(String tipo, String line1, String line2, String line3, double offset2, double offset3) {
        this.tipo = tipo;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.offset2 = offset2;
        this.offset3 = offset3;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public double getOffset1() {
        return offset1;
    }

    public void setOffset1(double offset1) {
        this.offset1 = offset1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public double getOffset2() {
        return offset2;
    }

    public void setOffset2(double offset2) {
        this.offset2 = offset2;
    }

    public double getOffset3() {
        return offset3;
    }

    public void setOffset3(double offset3) {
        this.offset3 = offset3;
    }

    public double[][] prepararDistancias() {
        //vai preencher a matriz
        double[][] matrizAlfabetica = new double[26][26];
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        switch (getTipo()) {
            case "Neutro":
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (i == j) {
                            matrizAlfabetica[i][j] = 0;
                        } else {
                            matrizAlfabetica[i][j] = 1;
                        }
                    }
                }
                break;

            case "QWERTY":
                char[][] matrizQWERTY = new char[3][10];
                matrizQWERTY[0][0] = 'q';
                matrizQWERTY[0][1] = 'w';
                matrizQWERTY[0][2] = 'e';
                matrizQWERTY[0][3] = 'r';
                matrizQWERTY[0][4] = 't';
                matrizQWERTY[0][5] = 'y';
                matrizQWERTY[0][6] = 'u';
                matrizQWERTY[0][7] = 'i';
                matrizQWERTY[0][8] = 'o';
                matrizQWERTY[0][9] = 'p';

                matrizQWERTY[1][0] = 'a';
                matrizQWERTY[1][1] = 's';
                matrizQWERTY[1][2] = 'd';
                matrizQWERTY[1][3] = 'f';
                matrizQWERTY[1][4] = 'g';
                matrizQWERTY[1][5] = 'h';
                matrizQWERTY[1][6] = 'j';
                matrizQWERTY[1][7] = 'k';
                matrizQWERTY[1][8] = 'l';
                matrizQWERTY[1][9] = ' ';

                matrizQWERTY[2][0] = 'z';
                matrizQWERTY[2][1] = 'x';
                matrizQWERTY[2][2] = 'c';
                matrizQWERTY[2][3] = 'v';
                matrizQWERTY[2][4] = 'b';
                matrizQWERTY[2][5] = 'n';
                matrizQWERTY[2][6] = 'm';
                matrizQWERTY[2][7] = ' ';
                matrizQWERTY[2][8] = ' ';
                matrizQWERTY[2][9] = ' ';

                for (int a = 0; a < 26; a++) {
                    for (int b = 0; b < 26; b++) {
                        int indexAx = -1;
                        int indexAy = -1;
                        int indexBx = -1;
                        int indexBy = -1;
                        double offsetA = 0;
                        double offsetB = 0;
                        if (a != b) {
                            for (int c = 0; c < 3; c++) {
                                for (int d = 0; d < 10; d++) {

                                    if (matrizQWERTY[c][d] == alfabeto[a]) {
                                        indexAx = c;
                                        indexAy = d;
                                    }
                                    if (matrizQWERTY[c][d] == alfabeto[b]) {
                                        indexBx = c;
                                        indexBy = d;
                                    }

                                }
                            }
                            switch (indexAx) {
                                case 0:
                                    offsetA = getOffset1();
                                    break;
                                case 1:
                                    offsetA = getOffset2();
                                    break;
                                case 2:
                                    offsetA = getOffset3();
                                    break;
                            }
                            switch (indexBx) {
                                case 0:
                                    offsetB = getOffset1();
                                    break;
                                case 1:
                                    offsetB = getOffset2();
                                    break;
                                case 2:
                                    offsetB = getOffset3();
                                    break;
                            }

                            matrizAlfabetica[a][b] = Math.sqrt(Math.pow((indexAx - indexBx), 2) + Math.pow((indexAy + offsetA - indexBy + offsetB), 2));
                        }

                    }
                }
                break;
            case "QWERTZ":
                char[][] matrizQWERTZ = new char[3][10];
                matrizQWERTZ[0][0] = 'q';
                matrizQWERTZ[0][1] = 'w';
                matrizQWERTZ[0][2] = 'e';
                matrizQWERTZ[0][3] = 'r';
                matrizQWERTZ[0][4] = 't';
                matrizQWERTZ[0][5] = 'z';
                matrizQWERTZ[0][6] = 'u';
                matrizQWERTZ[0][7] = 'i';
                matrizQWERTZ[0][8] = 'o';
                matrizQWERTZ[0][9] = 'p';

                matrizQWERTZ[1][0] = 'a';
                matrizQWERTZ[1][1] = 's';
                matrizQWERTZ[1][2] = 'd';
                matrizQWERTZ[1][3] = 'f';
                matrizQWERTZ[1][4] = 'g';
                matrizQWERTZ[1][5] = 'h';
                matrizQWERTZ[1][6] = 'j';
                matrizQWERTZ[1][7] = 'k';
                matrizQWERTZ[1][8] = 'l';
                matrizQWERTZ[1][9] = ' ';

                matrizQWERTZ[2][0] = 'y';
                matrizQWERTZ[2][1] = 'x';
                matrizQWERTZ[2][2] = 'c';
                matrizQWERTZ[2][3] = 'v';
                matrizQWERTZ[2][4] = 'b';
                matrizQWERTZ[2][5] = 'n';
                matrizQWERTZ[2][6] = 'm';
                matrizQWERTZ[2][7] = ' ';
                matrizQWERTZ[2][8] = ' ';
                matrizQWERTZ[2][9] = ' ';

                for (int a = 0; a < 26; a++) {
                    for (int b = 0; b < 26; b++) {
                        int indexAx = -1;
                        int indexAy = -1;
                        int indexBx = -1;
                        int indexBy = -1;
                        double offsetA = 0;
                        double offsetB = 0;
                        if (a != b) {
                            for (int c = 0; c < 3; c++) {
                                for (int d = 0; d < 10; d++) {

                                    if (matrizQWERTZ[c][d] == alfabeto[a]) {
                                        indexAx = c;
                                        indexAy = d;
                                    }
                                    if (matrizQWERTZ[c][d] == alfabeto[b]) {
                                        indexBx = c;
                                        indexBy = d;
                                    }

                                }
                            }
                            switch (indexAx) {
                                case 0:
                                    offsetA = getOffset1();
                                    break;
                                case 1:
                                    offsetA = getOffset2();
                                    break;
                                case 2:
                                    offsetA = getOffset3();
                                    break;
                            }
                            switch (indexBx) {
                                case 0:
                                    offsetB = getOffset1();
                                    break;
                                case 1:
                                    offsetB = getOffset2();
                                    break;
                                case 2:
                                    offsetB = getOffset3();
                                    break;
                            }

                            matrizAlfabetica[a][b] = Math.sqrt(Math.pow((indexAx - indexBx), 2) + Math.pow((indexAy + offsetA - indexBy + offsetB), 2));
                        }

                    }
                }
                break;
            case "AZERTY":
                char[][] matrizAZERTY = new char[3][10];
                matrizAZERTY[0][0] = 'a';
                matrizAZERTY[0][1] = 'z';
                matrizAZERTY[0][2] = 'e';
                matrizAZERTY[0][3] = 'r';
                matrizAZERTY[0][4] = 't';
                matrizAZERTY[0][5] = 'y';
                matrizAZERTY[0][6] = 'u';
                matrizAZERTY[0][7] = 'i';
                matrizAZERTY[0][8] = 'o';
                matrizAZERTY[0][9] = 'p';

                matrizAZERTY[1][0] = 'q';
                matrizAZERTY[1][1] = 's';
                matrizAZERTY[1][2] = 'd';
                matrizAZERTY[1][3] = 'f';
                matrizAZERTY[1][4] = 'g';
                matrizAZERTY[1][5] = 'h';
                matrizAZERTY[1][6] = 'j';
                matrizAZERTY[1][7] = 'k';
                matrizAZERTY[1][8] = 'l';
                matrizAZERTY[1][9] = 'm';

                matrizAZERTY[2][0] = 'w';
                matrizAZERTY[2][1] = 'x';
                matrizAZERTY[2][2] = 'c';
                matrizAZERTY[2][3] = 'v';
                matrizAZERTY[2][4] = 'b';
                matrizAZERTY[2][5] = 'n';
                matrizAZERTY[2][6] = ' ';
                matrizAZERTY[2][7] = ' ';
                matrizAZERTY[2][8] = ' ';
                matrizAZERTY[2][9] = ' ';

                for (int a = 0; a < 26; a++) {
                    for (int b = 0; b < 26; b++) {
                        int indexAx = -1;
                        int indexAy = -1;
                        int indexBx = -1;
                        int indexBy = -1;
                        double offsetA = 0;
                        double offsetB = 0;
                        if (a != b) {
                            for (int c = 0; c < 3; c++) {
                                for (int d = 0; d < 10; d++) {

                                    if (matrizAZERTY[c][d] == alfabeto[a]) {
                                        indexAx = c;
                                        indexAy = d;
                                    }
                                    if (matrizAZERTY[c][d] == alfabeto[b]) {
                                        indexBx = c;
                                        indexBy = d;
                                    }

                                }
                            }
                            switch (indexAx) {
                                case 0:
                                    offsetA = getOffset1();
                                    break;
                                case 1:
                                    offsetA = getOffset2();
                                    break;
                                case 2:
                                    offsetA = getOffset3();
                                    break;
                            }
                            switch (indexBx) {
                                case 0:
                                    offsetB = getOffset1();
                                    break;
                                case 1:
                                    offsetB = getOffset2();
                                    break;
                                case 2:
                                    offsetB = getOffset3();
                                    break;
                            }

                            matrizAlfabetica[a][b] = Math.sqrt(Math.pow((indexAx - indexBx), 2) + Math.pow((indexAy + offsetA - indexBy + offsetB), 2));
                        }

                    }
                }
                break;
            case "DVORAK":
                char[][] matrizDVORAK = new char[3][10];
                matrizDVORAK[0][0] = 'p';
                matrizDVORAK[0][1] = 'y';
                matrizDVORAK[0][2] = 'f';
                matrizDVORAK[0][3] = 'g';
                matrizDVORAK[0][4] = 'c';
                matrizDVORAK[0][5] = 'r';
                matrizDVORAK[0][6] = 'l';
                matrizDVORAK[0][7] = ' ';
                matrizDVORAK[0][8] = ' ';
                matrizDVORAK[0][9] = ' ';

                matrizDVORAK[1][0] = 'a';
                matrizDVORAK[1][1] = 'o';
                matrizDVORAK[1][2] = 'e';
                matrizDVORAK[1][3] = 'u';
                matrizDVORAK[1][4] = 'i';
                matrizDVORAK[1][5] = 'd';
                matrizDVORAK[1][6] = 'h';
                matrizDVORAK[1][7] = 't';
                matrizDVORAK[1][8] = 'n';
                matrizDVORAK[1][9] = 's';

                matrizDVORAK[2][0] = 'q';
                matrizDVORAK[2][1] = 'j';
                matrizDVORAK[2][2] = 'k';
                matrizDVORAK[2][3] = 'x';
                matrizDVORAK[2][4] = 'b';
                matrizDVORAK[2][5] = 'm';
                matrizDVORAK[2][6] = 'w';
                matrizDVORAK[2][7] = 'v';
                matrizDVORAK[2][8] = 'z';
                matrizDVORAK[2][9] = ' ';

                for (int a = 0; a < 26; a++) {
                    for (int b = 0; b < 26; b++) {
                        int indexAx = -1;
                        int indexAy = -1;
                        int indexBx = -1;
                        int indexBy = -1;
                        double offsetA = 0;
                        double offsetB = 0;
                        if (a != b) {
                            for (int c = 0; c < 3; c++) {
                                for (int d = 0; d < 10; d++) {

                                    if (matrizDVORAK[c][d] == alfabeto[a]) {
                                        indexAx = c;
                                        indexAy = d;
                                        //System.out.println("char1("+indexAx+","+indexAy+")");
                                    }
                                    if (matrizDVORAK[c][d] == alfabeto[b]) {
                                        indexBx = c;
                                        indexBy = d;
                                        //System.out.println("char2("+indexBx+","+indexBy+")");
                                    }

                                }
                            }
                            switch (indexAx) {
                                case 0:
                                    offsetA = getOffset1();
                                    break;
                                case 1:
                                    offsetA = getOffset2();
                                    break;
                                case 2:
                                    offsetA = getOffset3();
                                    break;
                            }
                            switch (indexBx) {
                                case 0:
                                    offsetB = getOffset1();
                                    break;
                                case 1:
                                    offsetB = getOffset2();
                                    break;
                                case 2:
                                    offsetB = getOffset3();
                                    break;
                            }
                            //System.out.println("offsetchar1 = " + offsetA);
                            // System.out.println("offsetchar2 = " + offsetB);
                            matrizAlfabetica[a][b] = Math.sqrt(Math.pow((indexAx - indexBx), 2) + Math.pow((indexAy + offsetA - indexBy + offsetB), 2));
                        }

                    }
                }
                break;
            case "COLEMAN":
                char[][] matrizCOLEMAN = new char[3][10];
                matrizCOLEMAN[0][0] = 'q';
                matrizCOLEMAN[0][1] = 'w';
                matrizCOLEMAN[0][2] = 'f';
                matrizCOLEMAN[0][3] = 'p';
                matrizCOLEMAN[0][4] = 'g';
                matrizCOLEMAN[0][5] = 'j';
                matrizCOLEMAN[0][6] = 'l';
                matrizCOLEMAN[0][7] = 'u';
                matrizCOLEMAN[0][8] = 'y';
                matrizCOLEMAN[0][9] = ' ';

                matrizCOLEMAN[1][0] = 'a';
                matrizCOLEMAN[1][1] = 'r';
                matrizCOLEMAN[1][2] = 's';
                matrizCOLEMAN[1][3] = 't';
                matrizCOLEMAN[1][4] = 'd';
                matrizCOLEMAN[1][5] = 'h';
                matrizCOLEMAN[1][6] = 'n';
                matrizCOLEMAN[1][7] = 'e';
                matrizCOLEMAN[1][8] = 'i';
                matrizCOLEMAN[1][9] = 'o';

                matrizCOLEMAN[2][0] = 'z';
                matrizCOLEMAN[2][1] = 'x';
                matrizCOLEMAN[2][2] = 'c';
                matrizCOLEMAN[2][3] = 'v';
                matrizCOLEMAN[2][4] = 'b';
                matrizCOLEMAN[2][5] = 'k';
                matrizCOLEMAN[2][6] = 'm';
                matrizCOLEMAN[2][7] = ' ';
                matrizCOLEMAN[2][8] = ' ';
                matrizCOLEMAN[2][9] = ' ';

                for (int a = 0; a < 26; a++) {
                    for (int b = 0; b < 26; b++) {
                        int indexAx = -1;
                        int indexAy = -1;
                        int indexBx = -1;
                        int indexBy = -1;
                        double offsetA = 0;
                        double offsetB = 0;
                        if (a != b) {
                            for (int c = 0; c < 3; c++) {
                                for (int d = 0; d < 10; d++) {

                                    if (matrizCOLEMAN[c][d] == alfabeto[a]) {
                                        indexAx = c;
                                        indexAy = d;
                                    }
                                    if (matrizCOLEMAN[c][d] == alfabeto[b]) {
                                        indexBx = c;
                                        indexBy = d;
                                    }

                                }
                            }
                            switch (indexAx) {
                                case 0:
                                    offsetA = getOffset1();
                                    break;
                                case 1:
                                    offsetA = getOffset2();
                                    break;
                                case 2:
                                    offsetA = getOffset3();
                                    break;
                            }
                            switch (indexBx) {
                                case 0:
                                    offsetB = getOffset1();
                                    break;
                                case 1:
                                    offsetB = getOffset2();
                                    break;
                                case 2:
                                    offsetB = getOffset3();
                                    break;
                            }

                            matrizAlfabetica[a][b] = Math.sqrt(Math.pow((indexAx - indexBx), 2) + Math.pow((indexAy + offsetA - indexBy + offsetB), 2));
                        }

                    }
                }
                break;
            case "WORKMAN":
                char[][] matrizWORKMAN = new char[3][10];
                matrizWORKMAN[0][0] = 'q';
                matrizWORKMAN[0][1] = 'd';
                matrizWORKMAN[0][2] = 'r';
                matrizWORKMAN[0][3] = 'w';
                matrizWORKMAN[0][4] = 'b';
                matrizWORKMAN[0][5] = 'j';
                matrizWORKMAN[0][6] = 'f';
                matrizWORKMAN[0][7] = 'u';
                matrizWORKMAN[0][8] = 'p';
                matrizWORKMAN[0][9] = ' ';

                matrizWORKMAN[1][0] = 'a';
                matrizWORKMAN[1][1] = 's';
                matrizWORKMAN[1][2] = 'h';
                matrizWORKMAN[1][3] = 't';
                matrizWORKMAN[1][4] = 'g';
                matrizWORKMAN[1][5] = 'y';
                matrizWORKMAN[1][6] = 'n';
                matrizWORKMAN[1][7] = 'e';
                matrizWORKMAN[1][8] = 'o';
                matrizWORKMAN[1][9] = 'i';

                matrizWORKMAN[2][0] = 'z';
                matrizWORKMAN[2][1] = 'x';
                matrizWORKMAN[2][2] = 'm';
                matrizWORKMAN[2][3] = 'c';
                matrizWORKMAN[2][4] = 'v';
                matrizWORKMAN[2][5] = 'k';
                matrizWORKMAN[2][6] = 'l';
                matrizWORKMAN[2][7] = ' ';
                matrizWORKMAN[2][8] = ' ';
                matrizWORKMAN[2][9] = ' ';

                for (int a = 0; a < 26; a++) {
                    for (int b = 0; b < 26; b++) {
                        int indexAx = -1;
                        int indexAy = -1;
                        int indexBx = -1;
                        int indexBy = -1;
                        double offsetA = 0;
                        double offsetB = 0;
                        if (a != b) {
                            for (int c = 0; c < 3; c++) {
                                for (int d = 0; d < 10; d++) {

                                    if (matrizWORKMAN[c][d] == alfabeto[a]) {
                                        indexAx = c;
                                        indexAy = d;
                                    }
                                    if (matrizWORKMAN[c][d] == alfabeto[b]) {
                                        indexBx = c;
                                        indexBy = d;
                                    }

                                }
                            }
                            switch (indexAx) {
                                case 0:
                                    offsetA = getOffset1();
                                    break;
                                case 1:
                                    offsetA = getOffset2();
                                    break;
                                case 2:
                                    offsetA = getOffset3();
                                    break;
                            }
                            switch (indexBx) {
                                case 0:
                                    offsetB = getOffset1();
                                    break;
                                case 1:
                                    offsetB = getOffset2();
                                    break;
                                case 2:
                                    offsetB = getOffset3();
                                    break;
                            }

                            matrizAlfabetica[a][b] = Math.sqrt(Math.pow((indexAx - indexBx), 2) + Math.pow((indexAy + offsetA - indexBy + offsetB), 2));
                        }

                    }
                }
                break;
            default:
        }
        return matrizAlfabetica;
    }

    public double getDeletion(char c1, char c2) {
        return c1 * c2;
    }

    public double getInsertion(char c1, char c2) {
        return c1 * c2;
    }

    public double getTransposition(char c1, char c2) {
        return c1 * c2;
    }

}
