package linzi.ssm.springmvc.bean;

import lombok.Data;

@Data
public class User {

    private String username = "Default";

    private String password;

    private String cellphone;

    private boolean agreement;

}
