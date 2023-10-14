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

import java.sql.Timestamp;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aionemu.gameserver.network.loginserver.LoginServer;
import com.aionemu.gameserver.network.loginserver.serverpackets.SM_MACBAN_CONTROL;

import javolution.util.FastMap;

/**
 * @author KID
 */
public class BannedMacManager {
	private static BannedMacManager manager = new BannedMacManager();
	private final Logger log = LoggerFactory.getLogger(BannedMacManager.class);

	public static BannedMacManager getInstance() {
		return manager;
	}

	private Map<String, BannedMacEntry> bannedList = new FastMap<String, BannedMacEntry>();

	public final void banAddress(String address, long newTime, String details) {
		BannedMacEntry entry;
		if (bannedList.containsKey(address)) {
			if (bannedList.get(address).isActiveTill(newTime)) {
				return;
			} else {
				entry = bannedList.get(address);
				entry.updateTime(newTime);
			}
		} else {
			entry = new BannedMacEntry(address, newTime);
		}
		entry.setDetails(details);

		bannedList.put(address, entry);

		log.info("banned " + address + " to " + entry.getTime().toString() + " for " + details);
		LoginServer.getInstance().sendPacket(new SM_MACBAN_CONTROL((byte) 1, address, newTime, details));
	}

	public final boolean unbanAddress(String address, String details) {
		if (bannedList.containsKey(address)) {
			bannedList.remove(address);
			log.info("unbanned " + address + " for " + details);
			LoginServer.getInstance().sendPacket(new SM_MACBAN_CONTROL((byte) 0, address, 0, details));
			return true;
		} else {
			return false;
		}
	}

	public final boolean isBanned(String address) {
		if (bannedList.containsKey(address)) {
			return this.bannedList.get(address).isActive();
		} else {
			return false;
		}
	}

	public final void dbLoad(String address, long time, String details) {
		this.bannedList.put(address, new BannedMacEntry(address, new Timestamp(time), details));
	}

	public void onEnd() {
		log.info("Loaded " + this.bannedList.size() + " banned mac addesses");
	}
}