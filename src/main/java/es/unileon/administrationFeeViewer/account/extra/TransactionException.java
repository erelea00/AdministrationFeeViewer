/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.administrationFeeViewer.account.extra;

/**
 * 
 * @author EmanuelIosif
 *
 */
public class TransactionException extends Exception{

	private static final long serialVersionUID = 1L;

	public TransactionException(String msg) {
        super(msg);
    }
}
