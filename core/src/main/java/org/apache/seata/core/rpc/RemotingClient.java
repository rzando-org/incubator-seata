/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seata.core.rpc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;
import io.netty.channel.Channel;
import org.apache.seata.core.protocol.AbstractMessage;
import org.apache.seata.core.protocol.RpcMessage;
import org.apache.seata.core.rpc.netty.RmNettyRemotingClient;
import org.apache.seata.core.rpc.netty.TmNettyRemotingClient;
import org.apache.seata.core.rpc.processor.RemotingProcessor;
import org.apache.seata.core.protocol.MessageType;

/**
 * The interface remoting client.
 *
 * @since 1.3.0
 */
public interface RemotingClient {

    /**
     * client send sync request.
     * In this request, if
     * {@link RmNettyRemotingClient#isEnableClientBatchSendRequest()}
     * {@link TmNettyRemotingClient#isEnableClientBatchSendRequest()}
     * is enabled, the message will be sent in batches.
     *
     * @param msg transaction message {@code org.apache.seata.core.protocol}
     * @return server result message
     * @throws TimeoutException TimeoutException
     */
    Object sendSyncRequest(Object msg) throws TimeoutException;

    /**
     * client send sync request.
     *
     * @param channel client channel
     * @param msg     transaction message {@code org.apache.seata.core.protocol}
     * @return server result message
     * @throws TimeoutException TimeoutException
     */
    Object sendSyncRequest(Channel channel, Object msg) throws TimeoutException;

    /**
     * client send async request.
     *
     * @param channel client channel
     * @param msg     transaction message {@code org.apache.seata.core.protocol}
     */
    void sendAsyncRequest(Channel channel, Object msg);

    /**
     * client send async response.
     *
     * @param serverAddress server address
     * @param rpcMessage    rpc message from server request
     * @param msg           transaction message {@code org.apache.seata.core.protocol}
     */
    void sendAsyncResponse(String serverAddress, RpcMessage rpcMessage, Object msg);

    /**
     * On register msg success.
     *
     * @param serverAddress  the server address
     * @param channel        the channel
     * @param response       the response
     * @param requestMessage the request message
     */
    void onRegisterMsgSuccess(String serverAddress, Channel channel, Object response, AbstractMessage requestMessage);

    /**
     * On register msg fail.
     *
     * @param serverAddress  the server address
     * @param channel        the channel
     * @param response       the response
     * @param requestMessage the request message
     */
    void onRegisterMsgFail(String serverAddress, Channel channel, Object response, AbstractMessage requestMessage);

    /**
     * register processor
     *
     * @param messageType {@link MessageType}
     * @param processor   {@link RemotingProcessor}
     * @param executor    thread pool
     */
    void registerProcessor(final int messageType, final RemotingProcessor processor, final ExecutorService executor);
}
