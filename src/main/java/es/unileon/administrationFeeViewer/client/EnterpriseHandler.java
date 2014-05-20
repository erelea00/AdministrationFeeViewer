/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.administrationFeeViewer.client;

import es.unileon.administrationFeeViewer.handler.Handler;

/**
 * Identifier of enterprises
 * @author EmanuelIosif
 */

//TODO modify cif with the corresponding data
public class EnterpriseHandler implements Handler{

    /**
     * 
     */
    char letter;
    
    /**
     * 
     */
    int cif;

    /**
     * 
     * @param letter
     * @param cif 
     */
    public EnterpriseHandler(char letter, int cif) {
        this.letter=letter;
        this.cif = cif;
        
    }
    
    @Override
    public int compareTo(Handler another) {
        return toString().compareTo(another.toString());
    }
    
    @Override
    public String toString(){
        return letter + Integer.toString(cif);
    }
    
}
