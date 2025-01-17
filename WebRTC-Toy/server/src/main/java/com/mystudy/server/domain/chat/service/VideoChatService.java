package com.mystudy.server.domain.chat.service;

import com.mystudy.server.domain.chat.dto.ChatRoomDto;
import com.mystudy.server.domain.chat.dto.ChatRoomList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoChatService {

    public ChatRoomDto createChatRoom(String name, String pw, boolean isLocked, int maxUserCnt){
        ChatRoomDto chatRoom = ChatRoomDto.builder()
                .roomId(UUID.randomUUID().toString())
                .roomName(name)
                .roomPassword(pw)
                .isLocked(isLocked)
                .userCount(0)
                .maxUserCount(maxUserCnt)
                .userList(new HashMap<String, WebSocketSession>())
                .chatType(ChatRoomDto.ChatType.VIDEO)
                .build();

        ChatRoomList.getInstance().getChatRooms().put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    public ChatRoomDto getChatRoom(String roomId){
        return ChatRoomList.getInstance().getChatRooms().get(roomId);
    }

    public Map<String, WebSocketSession> addClient (String roomId, String name, WebSocketSession session){
        ChatRoomDto chatRoom = getChatRoom(roomId);
        Map<String, WebSocketSession> userList = (Map<String, WebSocketSession>)chatRoom.getUserList();
        userList.put(name, session);
        return userList;
    }

    public boolean removeClient(){
        //이거 구현하다가 말았음
        return false;
    }
}
