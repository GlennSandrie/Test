/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Lisa
 */
public class InvalidCoordinateException extends Exception
{
    public InvalidCoordinateException()
    {
        super();
    }
    public InvalidCoordinateException(String boodschap)
    {
        super(boodschap);
    }
    public InvalidCoordinateException(Throwable t)
    {
        super(t);
    }
    public InvalidCoordinateException(String boodschap, Throwable t)
    {
        super(boodschap,t);
    }
}
