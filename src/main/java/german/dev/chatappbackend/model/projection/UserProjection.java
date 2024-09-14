package german.dev.chatappbackend.model.projection;

import java.time.LocalDateTime;

public interface UserProjection {

    Long getId();
    String getUsername();
    String getEmail();
    LocalDateTime getCreatedAt();
    String getRol();
    String getStatus();
}
