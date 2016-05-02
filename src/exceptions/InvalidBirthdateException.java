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

    /**
     * eerste constructor InvalidBirthdateException
     */
    public InvalidBirthdateException()
    {
        super();
    }

    /**
     * tweede constructor InvalidBirthdateException
     *
     * @param boodschap
     */
    public InvalidBirthdateException(String boodschap)
    {
        super(boodschap);
    }

    /**
     * derde constructor InvalidBirthdateException
     *
     * @param t
     */
    public InvalidBirthdateException(Throwable t)
    {
        super(t);
    }

    /**
     * vierde constructor InvalidBirthdateException
     *
     * @param boodschap
     * @param t
     */
    public InvalidBirthdateException(String boodschap, Throwable t)
    {
        super(boodschap, t);
    }

}
