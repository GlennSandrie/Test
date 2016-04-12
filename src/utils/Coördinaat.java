/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Glenn
 */
public enum Coördinaat {

    XCOORDINAAT1(1, "l"), XCOORDINAAT2(2, "2"), XCOORDINAAT3(3, "3"), XCOORDINAAT4(4, "4"), XCOORDINAAT5(5, "5"), XCOORDINAAT6(6, "6"), XCOORDINAAT7(7, "7"),
    YCOORDINAAT1(8, "A"), YCOORDINAAT2(9, "B"), YCOORDINAAT3(10, "C"), YCOORDINAAT4(11, "D"), YCOORDINAAT5(12, "E"), YCOORDINAAT6(13, "F"), YCOORDINAAT7(14, "G"),
    BEGINCOORDINAAT(15," ");
    
    private final int CoördinaatId;
    private final String Coördinaat;

    private Coördinaat(int CoördinaatId, String Coördinaat) 
    {
        
        this.CoördinaatId = CoördinaatId;
        this.Coördinaat = Coördinaat;
    }

    public int getCoördinaatId() 
    {
        return CoördinaatId;
    }

    public String getCoördinaat() 
    {
        return Coördinaat;
    }

    
}