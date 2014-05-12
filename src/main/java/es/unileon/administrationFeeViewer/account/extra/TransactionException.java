/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.administrationFeeViewer.account.extra;

/**
 *
 * @author runix
 */
public class TransactionException extends Exception{

	private static final long serialVersionUID = 1L;

	public TransactionException(String msg) {
        super(msg);
    }
}
