/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.administrationFeeViewer.handler;

/**
 *
 * @author runix
 *
 */
public class GenericHandler implements Handler {

    /**
     * Generic id
     */
    private String id;

    /**
     * Create a new Generic Handler
     *
     * @param id (The id)
     * @author runix
     */
    public GenericHandler(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Handler another) {
        return this.id.compareTo(another.toString());
    }

    @Override
    public String toString() {
        return this.id;
    }

}
