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
    public EmptyListException()
    {
        super();
    }
    public EmptyListException(String boodschap)
    {
        super(boodschap);
    }
    public EmptyListException(Throwable t)
    {
        super(t);
    }
    public EmptyListException(String boodschap, Throwable t)
    {
        super(boodschap,t);
    }
}
