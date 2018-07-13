package be.kdg.springproject.dom.user.roles;

import be.kdg.springproject.dom.user.exceptions.UserException;
import be.kdg.springproject.dom.user.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@DiscriminatorColumn(name = "RoleType", discriminatorType = DiscriminatorType.STRING)
public abstract class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId", nullable = false)
    private Integer roleId;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_USER_ID")
    private User user;



    public static <T extends Role> boolean hasRole(User user, Class<T> role) throws UserException {
        try {
            loadRole(user, role);
            return true;
        } catch (UserException use) {
            return false;
        }
    }

    public static <T extends Role> T loadRole(User user, Class<T> role) throws UserException {
        List<Role> roles = user.getRoles();
        Optional<T> result = (Optional<T>) roles
                .stream()
                .filter(r -> role.isInstance(r))
                .findAny();

        if (!result.isPresent())
            throw new UserException("Incorrect role for user");

        return result.get();
    }

    public abstract Collection<? extends GrantedAuthority> getAuthorities();


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public static List<Role> createRoles(List<RoleType> roleTypes) {
        return roleTypes.stream().map(roleType -> toRole(roleType)).collect(Collectors.toList());
    }

    public static Role toRole(RoleType roleType) {
        switch (roleType) {
            case ROLE_ADMIN:
                return new Adminstrator();
            default:
                return new Client();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public abstract RoleType getRoleType();

    @Override
    public int hashCode() {
        return roleId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return roleId.equals(role.roleId);

    }

    public enum RoleType {
        ROLE_CLIENT, ROLE_REPAIRER, ROLE_ADMIN
    }
}
