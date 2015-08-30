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

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import core.SystemContext;
import exception.EbayException;

/**
 *
 * @author Aaron
 */

public class ThreadActorDispatcher implements ActorDispatcher, Runnable {
	// private static final Logger LOG = LoggerFactory
	// .getLogger(ThreadActorDispatcher.class);
	private BlockingQueue<Actor> actorQueue;

	private Thread dispatchThread;

	public ThreadActorDispatcher() {
		this.actorQueue = new LinkedBlockingQueue<Actor>();
	}

	@Override
	public void pushActor(Actor actor) {
		this.actorQueue.add(actor);
	}

	private boolean dispatchAction(Actor actor) {
		// try {
		actor.execute();
		// } catch (Throwable e) {
		// LOG.warn("QQActor dispatchAction Error!", e);
		// }
		return !(actor instanceof ExitActor);
	}

	/** {@inheritDoc} */
	@Override
	public void run() {
		try {
			// LOG.debug("QQActorDispatcher enter action loop...");
			while (dispatchAction(this.actorQueue.take())) {
			}
			// LOG.debug("QQActorDispatcher leave action loop...");
		} catch (InterruptedException e) {
			// LOG.debug("QQActorDispatcher interrupted.");
		}
	}

	/** {@inheritDoc} */
	@Override
	public void init(SystemContext context) {
		actorQueue.clear();
		dispatchThread = new Thread(this);
		dispatchThread.setName("ThreadActorDispatcher");
		dispatchThread.start();
	}

	@Override
	public void destroy() {
		pushActor(new ExitActor());
		if (Thread.currentThread() != dispatchThread) {
			try {
				dispatchThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class ExitActor extends Actor {

		@Override
		public void execute() {
			// TODO Auto-generated method stub

		}
	}
}
