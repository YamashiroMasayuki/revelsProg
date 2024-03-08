package DataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {
    private String USER_ID;
    private String USER_PASS;
    private String USER_FIRSTNAME;
    private String USER_LASTNAME;
    private int USER_YUKYUBI;
    private String UPDATE_DAY;
    private String CREATE_DAY;
    private int IS_DLTFLG;
    private int IS_ADMINISTRATOR;
}
