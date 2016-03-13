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
    public WrongInputException()
    {
        super();
    }
    public WrongInputException(String boodschap)
    {
        super(boodschap);
    }
    public WrongInputException(Throwable t)
    {
        super(t);
    }
    public WrongInputException(String boodschap, Throwable t)
    {
        super(boodschap,t);
    }
}
