package com.example.demo.DataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailData {
    private String USER_ID;
    private int MAIL_CATEGORY;
    private String FIX_DATE_TIME;
    private String FIX_STARTWORK_TIME;
    private String FIX_FINISHWORK_TIME;
    private String MAIL_REMARKS;
    private int SHINSEI_STATUS_KBN;
}