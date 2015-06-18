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

/**
 * Project  : WebQQCore
 * Package  : iqq.im.core
 * File     : QQEventDispatcher.java
 * Author   : solosky < solosky772@qq.com >
 * Created  : 2012-8-2
 * License  : Apache License 2.0 
 */
package actor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import exception.EbayException;

/**
 *
 * 单线程的QQ内部分发器，可以同时使用多个QQ实例�?
 *
 * @author solosky
 */
public class ThreadActorDispatcher implements EbayActorDispatcher, Runnable {
	private static final Logger LOG = LoggerFactory
			.getLogger(ThreadActorDispatcher.class);
	private BlockingQueue<EbayActor> actorQueue;
	private Thread dispatchThread;

	/**
	 * 默认构�?�函数，不会自动启动action循环
	 */
	public ThreadActorDispatcher() {
		this.actorQueue = new LinkedBlockingQueue<QQActor>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iqq.im.actor.QQActorDispatcher#pushActor(iqq.im.actor.QQActor)
	 */
	/** {@inheritDoc} */
	@Override
	public void pushActor(QQActor actor) {
		this.actorQueue.add(actor);
	}

	/**
	 * 执行�?个QQActor，返回是否继续下�?个actor
	 */
	private boolean dispatchAction(QQActor actor) {
		try {
			actor.execute();
		} catch (Throwable e) {
			LOG.warn("QQActor dispatchAction Error!", e);
		}
		return !(actor instanceof ExitActor);
	}

	/** {@inheritDoc} */
	@Override
	public void run() {
		try {
			LOG.debug("QQActorDispatcher enter action loop...");
			while (dispatchAction(this.actorQueue.take())) {
			}
			LOG.debug("QQActorDispatcher leave action loop...");
		} catch (InterruptedException e) {
			LOG.debug("QQActorDispatcher interrupted.");
		}
	}

	/** {@inheritDoc} */
	@Override
	public void init(QQContext context) throws QQException {
		actorQueue.clear();
		dispatchThread = new Thread(this);
		dispatchThread.setName("QQActorDispatcher");
		dispatchThread.start();
	}

	/** {@inheritDoc} */
	@Override
	public void destroy() throws QQException {
		pushActor(new ExitActor());
		try {
			if (Thread.currentThread() != dispatchThread) {
				dispatchThread.join();
			}
		} catch (InterruptedException e) {
			throw new QQException(QQException.QQErrorCode.UNKNOWN_ERROR, e);
		}
	}

	/**
	 * 
	 * �?个伪Actor只是为了让ActorLoop停下�?
	 *
	 * @author solosky
	 *
	 */
	public class ExitActor implements QQActor {
		@Override
		public void execute() {
			// do nothing
		}
	}

	@Override
	public void init() throws EbayException {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushActor(EbayActor actor) {
		// TODO Auto-generated method stub

	}

}
