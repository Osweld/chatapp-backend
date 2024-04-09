package com.chat.socket.chatappbackend.email.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivateAccountMessage {

        private String to;
        private String subject;
        private String body;
        private String UniqueCode;
}
