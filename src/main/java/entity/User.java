package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User entity, includes Builder and Role Enum
 */
public class User implements Serializable {
    private long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime created;

    private User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setId(long id) {
            User.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            User.this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            User.this.role = role;
            return this;
        }

        public Builder setCreated(LocalDateTime created) {
            User.this.created = created;
            return this;
        }

        public User build() {
            return User.this;
        }

    }

    public enum Role {
        USER,
        MASTER,
        ADMIN
    }
}
