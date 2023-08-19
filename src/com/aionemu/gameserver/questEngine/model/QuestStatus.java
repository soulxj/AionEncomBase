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
package com.aionemu.gameserver.questEngine.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * @author MrPoke
 */

@XmlEnum
public enum QuestStatus {
	NONE(0), // Default status. Aborted quests and the quests, where the quest timer ended. Used for beginning a new
	// quest. Stored together with other quests in the player's quest list, so don't count them! Invisible
	// in the player's quest list
	START(3), // Accepted quests
	REWARD(4), // The quests, that are finished. "Go and get your reward"
	COMPLETE(5), // Completed quests
	LOCKED(6); // Not (yet) available quests

	private int id;

	private QuestStatus(int id) {
		this.id = id;
	}

	public int value() {
		return id;
	}
}