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
package com.aionemu.gameserver.network.aion.serverpackets;

import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;

/**
 * @author xTz
 */
public class SM_INSTANCE_STAGE_INFO extends AionServerPacket {

	private int type;
	private int event;
	private int unk;

	public SM_INSTANCE_STAGE_INFO(int type, int event, int unk) {
		this.type = type;
		this.event = event;
		this.unk = unk;
	}

	@Override
	protected void writeImpl(AionConnection con) {
		writeC(type);
		writeD(0);
		writeH(event);
		writeH(unk);
	}
}