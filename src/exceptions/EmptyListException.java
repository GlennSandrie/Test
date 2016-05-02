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
public class EmptyListException extends Exception
{

    /**
     * eerste constructor emptyListException
     */
    public EmptyListException()
    {
        super();
    }

    /**
     * tweede constructor emptyListException
     *
     * @param boodschap
     */
    public EmptyListException(String boodschap)
    {
        super(boodschap);
    }

    /**
     * derde constructor emptyListException
     *
     * @param t
     */
    public EmptyListException(Throwable t)
    {
        super(t);
    }

    /**
     * vierde constructor emptyListException
     *
     * @param boodschap
     * @param t
     */
    public EmptyListException(String boodschap, Throwable t)
    {
        super(boodschap, t);
    }
}
