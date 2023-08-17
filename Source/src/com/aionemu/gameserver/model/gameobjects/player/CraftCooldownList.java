/*
 * This file is part of Encom. **ENCOM FUCK OTHER SVN**
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
package com.aionemu.gameserver.model.gameobjects.player;

import javolution.util.FastMap;

/**
 * @author synchro2
 */
public class CraftCooldownList {

	private FastMap<Integer, Long> craftCooldowns;

	CraftCooldownList(Player owner) {
	}

	public boolean isCanCraft(int delayId) {
		if (craftCooldowns == null || !craftCooldowns.containsKey(delayId)) {
			return true;
        }
		Long coolDown = craftCooldowns.get(delayId);
		if (coolDown == null) {
			return true;
        }
		if (coolDown < System.currentTimeMillis()) {
			craftCooldowns.remove(delayId);
			return true;
		}
		return false;
	}

	public long getCraftCooldown(int delayId) {
		if (craftCooldowns == null || !craftCooldowns.containsKey(delayId)) {
			return 0;
        }
		return craftCooldowns.get(delayId);
	}

	public FastMap<Integer, Long> getCraftCoolDowns() {
		return craftCooldowns;
	}

	public void setCraftCoolDowns(FastMap<Integer, Long> craftCoolDowns) {
		this.craftCooldowns = craftCoolDowns;
	}

	public void addCraftCooldown(int delayId, int delay) {
		if (craftCooldowns == null) {
			craftCooldowns = new FastMap<Integer, Long>();
		}

		long nextUseTime = System.currentTimeMillis() + (delay * 1000);
		craftCooldowns.put(delayId, nextUseTime);
	}
}