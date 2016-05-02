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
public class WrongInputException extends IllegalArgumentException
{

    /**
     * eerste constructor WrongInputException
     */
    public WrongInputException()
    {
        super();
    }

    /**
     * tweede constructor WrongInputException
     *
     * @param boodschap
     */
    public WrongInputException(String boodschap)
    {
        super(boodschap);
    }

    /**
     * derde constructor WrongInputException
     *
     * @param t
     */
    public WrongInputException(Throwable t)
    {
        super(t);
    }

    /**
     * vierde constructor WrongInputException
     *
     * @param boodschap
     * @param t
     */
    public WrongInputException(String boodschap, Throwable t)
    {
        super(boodschap, t);
    }
}
