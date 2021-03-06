package com.phei.netty.protocol.http.json.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;

import java.util.List;

/**
 * @author pengzhe
 * @date 2018-12-25 21:42
 * @description 响应消息解码器, 供HTTP客户端对应答消息进行自动解码使用
 */

public class HttpJsonResponseDecoder extends AbstractHttpJsonDecoder<FullHttpResponse> {
    public HttpJsonResponseDecoder(Class<?> clazz) {
        this(clazz, false);
    }

    /**
     * 构造器
     *
     * @param clazz   解码的对象信息
     * @param isPrint 是否需要打印
     */
    public HttpJsonResponseDecoder(Class<?> clazz, boolean isPrint) {
        super(clazz, isPrint);
    }

    /**
     * @param ctx channel上下文
     * @param msg 消息
     * @param out 输出集合
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, FullHttpResponse msg, List<Object> out) throws Exception {
        System.out.println("开始解码...");
        out.add(
                new HttpJsonResponse(msg, decode0(ctx, msg.content()))
        );
    }

}
