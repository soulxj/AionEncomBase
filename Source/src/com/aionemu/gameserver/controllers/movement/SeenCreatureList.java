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
package com.aionemu.gameserver.controllers.movement;

import com.aionemu.gameserver.model.gameobjects.Creature;
import javolution.util.FastMap;

public class SeenCreatureList {

	private FastMap<Integer, Creature> seenCreatures;

	public boolean add(Creature creature) {
		if (seenCreatures == null) {
			seenCreatures = FastMap.newInstance();
		}
		return seenCreatures.putIfAbsent(creature.getObjectId(), creature) == null;
	}

	public boolean remove(Creature creature) {
		if (seenCreatures == null) {
			return false;
		}
		return seenCreatures.remove(creature.getObjectId()) != null;
	}

	public void clear() {
		if (seenCreatures != null) {
			seenCreatures.clear();
		}
	}

	public boolean contains(Creature creature) {
		if (seenCreatures == null) {
			return false;
		}
		return seenCreatures.containsKey(creature.getObjectId());
	}
}