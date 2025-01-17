package com.mystudy.server.domain.chat.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ChatRoomList {
    private ChatRoomList(){

    }

    private static ChatRoomList chatRoomList = new ChatRoomList();
    private Map<String, ChatRoomDto> chatRooms = new LinkedHashMap<>();

    public static ChatRoomList getInstance(){
        return chatRoomList;
    }
}
