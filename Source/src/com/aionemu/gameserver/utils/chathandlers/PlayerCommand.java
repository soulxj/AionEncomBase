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
package com.aionemu.gameserver.utils.chathandlers;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.utils.PacketSendUtility;

/**
 * @author synchro2
 */
public abstract class PlayerCommand extends ChatCommand {

	public PlayerCommand(String alias) {
		super(alias);
	}

	@Override
	public boolean checkLevel(Player player) {
		return player.havePermission(getLevel());
	}

	@Override
	boolean process(Player player, String text) {
		if (!checkLevel(player)) {
			PacketSendUtility.sendMessage(player, "You not have permission for use this command.");
			return true;
		}

		boolean success = false;
		if (text.length() == getAlias().length()) {
			success = this.run(player, EMPTY_PARAMS);
		}
		else {
			success = this.run(player, text.substring(getAlias().length() + 1).split(" "));
        }
		return success;
	}
}