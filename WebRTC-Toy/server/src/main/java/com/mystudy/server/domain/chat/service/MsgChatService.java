package com.mystudy.server.domain.chat.service;

import com.mystudy.server.domain.chat.dto.ChatRoomDto;
import com.mystudy.server.domain.chat.dto.ChatRoomList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MsgChatService {

    public ChatRoomDto createChatRoom(String name, String pw, boolean isLocked, int maxUserCnt) {
        ChatRoomDto chatRoom = ChatRoomDto.builder()
                .roomId(UUID.randomUUID().toString())
                .roomName(name)
                .roomPassword(pw)
                .isLocked(isLocked)
                .userCount(0)
                .maxUserCount(maxUserCnt)
                .userList(new HashMap<String, String>())
                .chatType(ChatRoomDto.ChatType.MSG)
                .build();

        ChatRoomList.getInstance().getChatRooms().put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    public ChatRoomDto getChatRoom(String roomId) {
        return ChatRoomList.getInstance().getChatRooms().get(roomId);
    }

    public String addUser (String roomId, String userName){
        ChatRoomDto chatRoom = getChatRoom(roomId);
        String userUUID = UUID.randomUUID().toString();
        Map<String, String> userList = (Map<String,String>)chatRoom.getUserList();
        userList.put(userUUID, userName);
        chatRoom.setUserCount(userList.size());

        return userUUID;
    }

    public boolean removeUser (String roomId, String userName){
        ChatRoomDto room = ChatRoomList.getInstance().getChatRooms().get(roomId);
        Map<String, String> userList = (Map<String, String>)room.getUserList();

        if(userList.containsKey(userName)){
            userList.remove(userName);
            room.setUserCount(userList.size());
            return true;
        }
        return false;
    }
}
