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
 * Package  : iqq.im
 * File     : QQContext.java
 * Author   : solosky < solosky772@qq.com >
 * Created  : 2012-7-31
 * License  : Apache License 2.0 
 */
package core;

import event.EbayNotifyEvent;
import actor.EbayActor;

/**
 *
 * QQ环境上下文，�?有的模块都是用QQContext来获取对�?
 *
 * @author solosky
 */
public interface SystemContext {
	/**
	 * <p>
	 * pushActor.
	 * </p>
	 *
	 * @param actor
	 *            a {@link iqq.im.actor.QQActor} object.
	 */
	public void pushActor(EbayActor actor);

	/**
	 * <p>
	 * fireNotify.
	 * </p>
	 *
	 * @param event
	 *            a {@link iqq.im.event.QQNotifyEvent} object.
	 */
	public void fireNotify(EbayNotifyEvent event);

	/**
	 * <p>
	 * getModule.
	 * </p>
	 *
	 * @param type
	 *            a {@link iqq.im.core.QQModule.Type} object.
	 * @param <T>
	 *            a T object.
	 * @return a T object.
	 */
	public <T extends Module> T getModule(Module.Type type);

	/**
	 * <p>
	 * getSerivce.
	 * </p>
	 *
	 * @param type
	 *            a {@link iqq.im.core.QQService.Type} object.
	 * @param <T>
	 *            a T object.
	 * @return a T object.
	 */
	public <T extends Service> T getSerivce(Service.Type type);

	/**
	 * <p>
	 * getAccount.
	 * </p>
	 *
	 * @return a {@link iqq.im.bean.QQAccount} object.
	 */
//	public QQAccount getAccount();

	/**
	 * <p>
	 * getSession.
	 * </p>
	 *
	 * @return a {@link iqq.im.core.QQSession} object.
	 */
//	public QQSession getSession();

	/**
	 * <p>
	 * getStore.
	 * </p>
	 *
	 * @return a {@link iqq.im.core.QQStore} object.
	 */
//	public QQStore getStore();
}
