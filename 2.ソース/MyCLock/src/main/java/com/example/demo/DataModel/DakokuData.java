package com.example.demo.DataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DakokuData {
    private String USER_ID;
    private String DAKOKU_DATE;
    private String STARTWORK_TIME;
    private String FINISHWORK_TIME;
    private int IS_YUKYU;
    private int DAKOKU_STATUS_KBN;
}
