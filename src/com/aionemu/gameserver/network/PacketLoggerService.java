/*

 *
 *  Encom is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Encom is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser Public License
 *  along with Encom.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aionemu.gameserver.configs.administration.DeveloperConfig;

/**
 * @author Ghostfur (Aion-Unique)
 */
public class PacketLoggerService {

	private static final Logger log = LoggerFactory.getLogger(PacketLoggerService.class);

	public void logPacketCM(String name) {
		if (DeveloperConfig.SHOW_PACKETS) {
			log.info("[PACKET CLIENT] " + name);
		}
	}

	public void logPacketSM(String name) {
		if (DeveloperConfig.SHOW_PACKETS) {
			log.info("[PACKET SERVER] " + name);
		}
	}

	@SuppressWarnings("synthetic-access")
	private static class SingletonHolder {

		protected static final PacketLoggerService instance = new PacketLoggerService();
	}

	public static final PacketLoggerService getInstance() {
		return SingletonHolder.instance;
	}
}