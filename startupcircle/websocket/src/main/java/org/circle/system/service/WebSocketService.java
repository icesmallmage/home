package org.circle.system.service;

import com.circle.common.core.redis.RedisCache;
import com.circle.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket 服务类
 */
@Component
@ServerEndpoint("/websocket/{terminalId}")
public class WebSocketService {

    private final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    @Autowired
    public RedisCache redisCache;

    /**
     * 保存连接信息
     */
    private static Map<String, Session> CLIENTS = new ConcurrentHashMap<>();
    private static final Map<String, AtomicInteger> TERMINAL_IDS = new HashMap<>();



    @OnOpen
    public void onOpen(@PathParam("terminalId") String terminalId, Session session) throws Exception {
        logger.info(session.getRequestURI().getPath() + "，打开连接开始：" + session.getId());

        Set<Session> setSession = new HashSet<>();

        TERMINAL_IDS.put(terminalId, new AtomicInteger(0));
        CLIENTS.put(terminalId, session);

        redisCache.setCacheObject(session.getId(), terminalId);
        if(StringUtils.isNull(redisCache.getCacheSet(terminalId))){
            setSession = redisCache.getCacheSet(terminalId);
        }
        setSession.add(session);
        redisCache.setCacheSet(terminalId, setSession);

        logger.info(session.getRequestURI().getPath() + "，打开连接完成：" + session.getId());

    }

    @OnClose
    public void onClose(@PathParam("terminalId") String terminalId, Session session) throws Exception {
        logger.info(session.getRequestURI().getPath() + "，关闭连接开始：" + session.getId());

        Set<Session> setSession = new HashSet<>();

        CLIENTS.remove(terminalId);
        TERMINAL_IDS.remove(terminalId);

        redisCache.deleteObject(session.getId());
        if(StringUtils.isNull(redisCache.getCacheSet(terminalId))){
            setSession = redisCache.getCacheSet(terminalId);
        }
        setSession.remove(session);
        redisCache.setCacheSet(terminalId, setSession);

        logger.info(session.getRequestURI().getPath() + "，关闭连接完成：" + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("前台发送消息：" + message);

        sendMessage("收到消息：" + message, session);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error(error.toString());
    }

    public void onClose(Session session) {
        // 判断当前连接是否在线
        if (!session.isOpen()) {
            return;
        }
        try {
            session.close();
        } catch (IOException e) {
            logger.error("连接关闭连接异常：" + e);
        }
    }

    public void sendMessage(String message, Session session) {
        try {
            Set<Session> setSession = new HashSet<>();
            // 从redis获取当前登录人的群聊
            String terminalId = redisCache.getCacheObject(session.getId());
            if(StringUtils.isNull(redisCache.getCacheSet(terminalId))){
                setSession = redisCache.getCacheSet(terminalId);
            }
            Iterator<Session> iterator = setSession.iterator();
            while (iterator.hasNext()){
                Session allSession =  iterator.next();
                allSession.getAsyncRemote().sendText(message);
            }
            logger.info("推送消息成功：" + message);
        } catch (Exception e) {
            logger.error("推送异常：" + e);
        }
    }

    public boolean sendMessage(String terminalId, String message) {
        try {
            Session session = CLIENTS.get(terminalId);
            session.getAsyncRemote().sendText(message);
            logger.info("推送消息成功：" + message);
            return true;
        } catch (Exception e) {
            logger.error("推送异常：" + e);
            return false;
        }
    }
}
