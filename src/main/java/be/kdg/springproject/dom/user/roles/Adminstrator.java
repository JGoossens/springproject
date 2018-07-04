package be.kdg.springproject.dom.user.roles;

public class Adminstrator extends Role {

    @Override
    public RoleType getRoleType() {
        return RoleType.ROLE_ADMIN;
    }
}
