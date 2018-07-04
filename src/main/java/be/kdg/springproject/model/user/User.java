package be.kdg.springproject.model.user;

import be.kdg.springproject.model.user.roles.Role;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Abstract class representing a user of the system. Every user is associated
 * with a Person. Every user has to have a unique username. This username takes
 * the form of an email address.
 *
 * @author wouter
 */
@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column
    private String username = null;

    @Column
    private String encryptedPassword;

    @OneToOne(targetEntity = Person.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name= "PersonId", nullable = false)
    private Person person;

    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(org.hibernate.annotations.FetchMode.SELECT)
    private List<Role> roles;

    public User() {
        this.person = new Person();
    }

    public User(Person person, String username, String encryptedPassword, List<Role> roles) {
        this.person = person;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int result = person != null ? person.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (encryptedPassword != null ? encryptedPassword.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (person != null ? !person.equals(user.person) : user.person != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (encryptedPassword != null ? !encryptedPassword.equals(user.encryptedPassword) : user.encryptedPassword != null)
            return false;
        return roles == user.roles;

    }

    @Override
    public String toString() {
        return "User{" + userId + ", " + username + ", " + encryptedPassword + '}';
    }
}
