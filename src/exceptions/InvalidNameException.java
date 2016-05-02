/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Aïssa
 */
public class InvalidNameException extends IllegalArgumentException
{
    /**
     * eerste constructor InvalidNameException
     */
    public InvalidNameException()
    {
        super();
    }
    
    /**
     * tweede constructor InvalidNameException
     * @param boodschap 
     */
    public InvalidNameException(String boodschap)
    {
        super(boodschap);
    }
    
    /**
     * derde constructor InvalidNameException
     * @param t 
     */
    public InvalidNameException(Throwable t)
    {
        super(t);
    }
    
    /**
     * vierde constructor InvalidNameException
     * @param boodschap
     * @param t 
     */
    public InvalidNameException(String boodschap, Throwable t)
    {
        super(boodschap,t);
    }
}
