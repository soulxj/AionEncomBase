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
package com.aionemu.gameserver.network.aion.serverpackets;

import com.aionemu.gameserver.model.siege.SiegeLocation;
import com.aionemu.gameserver.model.siege.SiegeType;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;
import javolution.util.FastList;

import java.util.Collection;

public class SM_ABYSS_ARTIFACT_INFO extends AionServerPacket {

	private Collection<SiegeLocation> locations;

	public SM_ABYSS_ARTIFACT_INFO(Collection<SiegeLocation> collection) {
		this.locations = collection;
	}

	@Override
	protected void writeImpl(AionConnection con) {
		FastList<SiegeLocation> validLocations = new FastList<SiegeLocation>();
		for (SiegeLocation loc : locations) {
			if (((loc.getType() == SiegeType.ARTIFACT) || (loc.getType() == SiegeType.FORTRESS))
				&& (loc.getLocationId() >= 1011) && (loc.getLocationId() <= 10412))
				validLocations.add(loc);
		}
		writeH(validLocations.size());
		for (SiegeLocation loc : validLocations) {
			writeD(loc.getLocationId());
			writeD(0); // unk
			writeD(0); // unk
		}
	}
}