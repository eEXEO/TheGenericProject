package entity;
// Generated 2020-01-07 14:55:57 by Hibernate Tools 4.3.1



/**
 * Officials generated by hbm2java
 */
public class Officials  implements java.io.Serializable {


     private Integer idof;
     private String name;
     private String surname;
     private String function;
     private String passwd;
     private String login;

    public Officials() {
    }

    public Officials(String name, String surname, String function, String passwd, String login) {
       this.name = name;
       this.surname = surname;
       this.function = function;
       this.passwd = passwd;
       this.login = login;
    }
   
    public Integer getIdof() {
        return this.idof;
    }
    
    public void setIdof(Integer idof) {
        this.idof = idof;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFunction() {
        return this.function;
    }
    
    public void setFunction(String function) {
        this.function = function;
    }
    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }




}


