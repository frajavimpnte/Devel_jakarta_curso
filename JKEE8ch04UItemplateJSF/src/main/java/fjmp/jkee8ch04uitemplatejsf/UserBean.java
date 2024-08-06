
package fjmp.jkee8ch04uitemplatejsf;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Named
@RequestScoped
public class UserBean implements Serializable {
    public long getTimeStamp() {
        return new Date().getTime();
    }
}
