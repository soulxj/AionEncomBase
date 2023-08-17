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
package com.aionemu.gameserver.services.siegeservice;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.siege.SiegeLocation;
import com.aionemu.gameserver.services.abyss.AbyssPointsService;

public class AbyssPointsListener extends AbyssPointsService.AddAPGlobalCallback {

	private final Siege<?> siege;

	public AbyssPointsListener(Siege<?> siege) {
		this.siege = siege;
	}

	public void onAbyssPointsAdded(Player player, int abyssPoints) {
		SiegeLocation fortress = siege.getSiegeLocation();

		if (fortress.isInsideLocation(player)) {
			siege.addAbyssPoints(player, abyssPoints);
		}
	}
}