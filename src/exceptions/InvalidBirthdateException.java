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
public class InvalidBirthdateException extends IllegalArgumentException
{
    public InvalidBirthdateException()
    {
        super();
    }
    public InvalidBirthdateException(String boodschap)
    {
        super(boodschap);
    }
    public InvalidBirthdateException(Throwable t)
    {
        super(t);
    }
    public InvalidBirthdateException(String boodschap, Throwable t)
    {
        super(boodschap,t);
    }
    
}
