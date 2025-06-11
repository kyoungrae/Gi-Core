package com.gicore.common.auth;

import com.gicore.common.common.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterRequest extends User {
    private String user_id;
    private String email;
    private String password;
}
