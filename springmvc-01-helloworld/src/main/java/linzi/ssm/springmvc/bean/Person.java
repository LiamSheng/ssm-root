package linzi.ssm.springmvc.bean;

import lombok.Data;

@Data
public class Person {

    private String username = "Linzi";

    private String password;

    private String cellphone;

    private boolean agreement;

    private Address address;

    private String sex;

    private String[] hobby;

    private String grade;

}
