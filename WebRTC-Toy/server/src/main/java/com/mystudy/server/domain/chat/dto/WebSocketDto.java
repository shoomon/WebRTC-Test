package com.mystudy.server.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketDto {
    private String from; //메세지를 보낸 유저 UUID
    private String type; //메세지 유형
    private String roomId; //채팅방 ID
    private Object candidate; //ICE Candidate
    private Object sdp; //SDP
}
