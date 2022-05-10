package com.cqupt.ws;

import com.cqupt.pojo.Message;
import com.cqupt.utils.MessageUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndPoint {
    private final static Logger LOGGER = LogManager.getLogger(ChatEndPoint.class);
    //存储在线用户
    public static Map<String,ChatEndPoint> onlineUsers = new ConcurrentHashMap<>();
    //给客户端发送消息的载体
    private Session session;
    //登录成功后 获取httpsession域中存放的username
    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig){
        LOGGER.info("websocket建立连接onOpen");
        this.session = session;
        //获取httpsession
        HttpSession httpSession = (HttpSession) endpointConfig.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        //获取httpsession中的username
        String username = (String) httpSession.getAttribute("username");
        //建立连接的用户存进onlineUsers
        onlineUsers.put(username,this);
    }

    @OnMessage
    public void onMessage(String message,Session session){
        LOGGER.info("websocket处理消息");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
        Message msg = objectMapper.readValue(message, Message.class);
        //获取接收消息的用户对象
        String toName = msg.getToName();
        //获取发送的消息
        String msgData = msg.getMessage();
        //获取当前登录的用户
        String username = (String)httpSession.getAttribute("username");
        //封装发送的消息
        String sendMsg = MessageUtils.getMessage(false, username, msgData);
        //发送消息
        onlineUsers.get(toName).session.getBasicRemote().sendText(sendMsg);
        }
        catch (JsonProcessingException e){
            LOGGER.error("转换出错");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        LOGGER.info("websocket断开连接");
        String username = (String) httpSession.getAttribute("username");
        onlineUsers.remove(username);
    }
    /**
     * 系统消息推送
     * @param message
     */
    private void broadcastMsgToAllOnlineUsers(String message){
        //所有登陆用户名称
        Set<String> names = onlineUsers.keySet();
        for (String name : names) {
            ChatEndPoint chatEndPoint = onlineUsers.get(name);
            //获取推送对象
            RemoteEndpoint.Basic basicRemote = chatEndPoint.session.getBasicRemote();
            try {
                basicRemote.sendText(message);
            }catch (Exception e){
                LOGGER.error("系统消息推送失败！");
                e.printStackTrace();
            }
        }
    }

    private Object getAllOnlineUsername() {
        return ChatEndPoint.onlineUsers.keySet();
    }
}
