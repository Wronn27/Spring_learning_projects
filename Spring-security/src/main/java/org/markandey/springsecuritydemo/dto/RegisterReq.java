package org.markandey.springsecuritydemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterReq {
    private String email;
    private String name;
    private String password;
}
