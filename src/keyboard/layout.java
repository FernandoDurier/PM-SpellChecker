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
    private double offset2;
    private double offset3;
    private double [][] matrizDistancias;

    public layout() {}
    
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
    
    public void prepararDistancias(layout layout){
    //vai preencher a matriz
        switch(layout.getTipo()){
                case "Neutro":
                    
                break;
                case "QWERTY":
                    
                break;
                case "QWERTZ":
                    
                break;
                case "AZERTY":
                    
                break;
                case "DVORAK":
                    
                break;
                case "COLEMAN":
                    
                break;
                case "WORKMAN":
                    
                break;
                default:
        }
    }
    
    public double getDeletion(char c1,char c2){
        return c1*c2;
    }
    public double getInsertion(char c1,char c2){
        return c1*c2;
    }
    public double getTransposition(char c1,char c2){
        return c1*c2;
    }
    
    
}
