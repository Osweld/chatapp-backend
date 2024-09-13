package german.dev.chatappbackend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    @Column(name = "username",nullable = false, unique = true,length = 20)
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 60, message = "Password must be between 8 and 60 characters")
    @Column(name = "password",nullable = false, length = 60)
    private String password;

    @NotBlank(message = "Email cannot be empty")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid email format")
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    @Column(name = "email",nullable = false, unique = true,length = 50)
    private String email;

    @NotNull(message = "Creation date cannot be null")
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;


    @NotNull(message = "Role cannot be null")
    @ManyToOne
    @JoinColumn(name = "id_rol",nullable = false)
    private Rol rol;

    @NotNull(message = "Status cannot be null")
    @ManyToOne
    @JoinColumn(name = "id_status",nullable = false)
    private Status status;

}
