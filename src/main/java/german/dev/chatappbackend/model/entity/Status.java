package german.dev.chatappbackend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;

    @NotBlank(message = "The status name cannot be empty")
    @Size(max = 25, message = "The status cannot exceed 25 characters")
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}
