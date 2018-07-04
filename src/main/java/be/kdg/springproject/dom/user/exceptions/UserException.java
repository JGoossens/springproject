/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.springproject.dom.user.exceptions;

/**
 * @author deketelw
 */
public class UserException extends RuntimeException
{
    /**
     * Deze exception wordt gesmeten wanneer iets fout gaat met het aanmelden
     * van een gebruiker. Bijvoorbeeld: fout password of foute gebruikersnaam
     *
     * @param message
     */
    public UserException(String message)
    {
        super(message);
    }
}
