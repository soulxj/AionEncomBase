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

import com.aionemu.gameserver.model.team.legion.LegionJoinRequest;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;

public class SM_LEGION_REQUEST_PLAYER extends AionServerPacket {
	private LegionJoinRequest ljr;

	public SM_LEGION_REQUEST_PLAYER(LegionJoinRequest ljr) {
		this.ljr = ljr;
	}

	@Override
	protected void writeImpl(AionConnection con) {
		writeD(ljr.getPlayerId());
		writeS(ljr.getPlayerName());
		writeC(ljr.getPlayerClass());
		writeC(ljr.getGenderId());
		writeH(ljr.getLevel());
		writeS(ljr.getMsg());
		writeD((int) ljr.getDate().getTime());
	}
}