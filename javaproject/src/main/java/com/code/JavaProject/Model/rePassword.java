package com.code.JavaProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class rePassword {
    private String username ;
    private String password ;
    private String newPassword;
    private String reNewPassword;
}
