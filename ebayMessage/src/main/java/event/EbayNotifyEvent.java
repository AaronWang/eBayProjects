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
 * Project  : WebQQCoreAsync
 * Package  : iqq.im.event
 * File     : NotifyEvent.java
 * Author   : solosky < solosky772@qq.com >
 * Created  : 2012-9-5
 * License  : Apache License 2.0 
 */
package event;

/**
 * <p>
 * QQNotifyEvent class.
 * </p>
 *
 * @author solosky
 */
public class EbayNotifyEvent extends EbayEvent {
	private Type type;
	private Object target;

	/**
	 * <p>
	 * Constructor for QQNotifyEvent.
	 * </p>
	 *
	 * @param type
	 *            a {@link iqq.im.event.QQNotifyEvent.Type} object.
	 * @param target
	 *            a {@link java.lang.Object} object.
	 */
	public EbayNotifyEvent(Type type, Object target) {
		this.type = type;
		this.target = target;
	}

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 *
	 * @return a {@link iqq.im.event.QQNotifyEvent.Type} object.
	 */
	public Type getType() {
		return type;
	}

	/**
	 * <p>
	 * Getter for the field <code>target</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.Object} object.
	 */
	public Object getTarget() {
		return target;
	}

	public static enum Type {
		/** 閲嶆柊鐧诲綍鎴愬姛 **/
		RELOGIN_SUCCESS,
		/** 缃戠粶杩炴帴鍑洪敊锛屽鎴风宸茬粡鎺夌嚎 */
		NET_ERROR,
		/** 鏈煡閿欒锛屽retcode澶氭鍑虹幇鏈煡鍊� */
		UNKNOWN_ERROR,
		/** 瀹㈡埛绔韪笅绾匡紝鍙兘鏄叾浠栧湴鏂圭櫥闄� */
		KICK_OFFLINE,
		/** 瀵规柟姝ｅ湪杈撳叆 */
		BUDDY_INPUT,
		/** 绐楀彛闇囧姩 */
		SHAKE_WINDOW,
		/** 鑱婂ぉ娑堟伅锛屽寘鎷ソ鍙嬶紝缇わ紝涓存椂浼氳瘽锛岃璁虹粍娑堟伅 */
		CHAT_MSG,
		/** 濂藉弸閫氱煡锛屽鍏朵粬浜鸿姹傛坊鍔犲ソ鍙嬶紝娣诲姞鍏朵粬鐢ㄦ埛璇锋眰閫氳繃鎴栬�呮嫆缁� */
		BUDDY_NOTIFY,
		/** 缇ら�氱煡锛屽绠＄悊鍛橀�氳繃鎴栨嫆缁濅簡娣诲姞缇よ姹傦紝缇ゆ垚鍛橀��鍑猴紝缇ゆ枃浠跺叡浜紝琚鐞嗗憳韪㈠嚭绛� */
		GROUP_NOTIFY,
		/** 鏂囦欢浼犺緭閫氱煡锛屽瀵规柟璇锋眰鍙戦�佹枃浠讹紝瀵规柟宸插悓鎰忔帴鍙楁枃浠剁瓑 */
		FILE_NOTIFY,
		/** 瑙嗛閫氱煡锛屽瀵规柟璇锋眰鍜屼綘瑙嗛锛屽鏂瑰悓鎰忚棰戠瓑銆傘�� */
		AV_NOTIFY,
		/** 绯荤粺骞挎挱 */
		SYSTEM_NOTIFY,
		/** 濂藉弸鐘舵�佹敼鍙� */
		BUDDY_STATUS_CHANGE,
		/** 楠岃瘉璇锋眰锛岄渶瑕佺敤鎴疯緭鍏ラ獙璇佺爜浠ョ户缁� */
		CAPACHA_VERIFY,
		/** 鏂伴偖浠堕�氱煡 */
		EMAIL_NOTIFY,
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "QQNotifyEvent [type=" + type + ", target=" + target + "]";
	}
}
