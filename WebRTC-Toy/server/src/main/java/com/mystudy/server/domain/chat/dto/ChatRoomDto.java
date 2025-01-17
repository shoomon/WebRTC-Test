package com.mystudy.server.domain.chat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@Builder
@EqualsAndHashCode
public class ChatRoomDto {
    public enum ChatType{
        MSG, VIDEO //문자채팅, 화상채팅
    }

    private String roomId; //채팅방 아이디
    private String roomName; //채팅방 이름
    private int userCount; //들어온 유저 수
    private int maxUserCount; //최대 유저 수

    private String roomPassword; //채팅방 삭제 시 필요한 pw
    private boolean isLocked; //채팅방 잠금 여부
    private ChatType chatType; //채팅방 타입
    private Map<String, ?> userList; //웹소켓 세션 또는 String 저장
}
