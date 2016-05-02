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

    /**
     * eerste constructor InvalidCoordinateException
     */
    public InvalidCoordinateException()
    {
        super();
    }

    /**
     * tweede constructor InvalidCoordinateException
     *
     * @param boodschap
     */
    public InvalidCoordinateException(String boodschap)
    {
        super(boodschap);
    }

    /**
     * derde constructor InvalidCoordinateException
     *
     * @param t
     */
    public InvalidCoordinateException(Throwable t)
    {
        super(t);
    }

    /**
     * vierde constructor InvalidCoordinateException
     *
     * @param boodschap
     * @param t
     */
    public InvalidCoordinateException(String boodschap, Throwable t)
    {
        super(boodschap, t);
    }
}
