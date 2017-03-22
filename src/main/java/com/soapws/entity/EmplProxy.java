package com.soapws.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="empl")
public class EmplProxy implements Serializable {

    private static final long serialVersionUID = -1958497361150454559L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String manager;
    private String department;

    public EmplProxy() {
    }
    public EmplProxy(long id) {
        this.id=id;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmplProxy{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", manager='" + manager + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmplProxy)) return false;

        EmplProxy emplProxy = (EmplProxy) o;

        if (getId() != emplProxy.getId()) return false;
        if (!getFirstName().equals(emplProxy.getFirstName())) return false;
        if (!getSecondName().equals(emplProxy.getSecondName())) return false;
        if (!getLastName().equals(emplProxy.getLastName())) return false;
        if (!getManager().equals(emplProxy.getManager())) return false;
        return getDepartment().equals(emplProxy.getDepartment());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getSecondName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getManager().hashCode();
        result = 31 * result + getDepartment().hashCode();
        return result;
    }
}