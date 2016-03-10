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
    public InvalidNameException()
    {
        super();
    }
    public InvalidNameException(String boodschap)
    {
        super(boodschap);
    }
    public InvalidNameException(Throwable t)
    {
        super(t);
    }
    public InvalidNameException(String boodschap, Throwable t)
    {
        super(boodschap,t);
    }
}
