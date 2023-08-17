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
package com.aionemu.gameserver.model.templates.towns;

import com.aionemu.gameserver.model.templates.spawns.Spawn;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author ViAl
 *
 */
@XmlType(name = "town_level")
public class TownLevel {

	@XmlAttribute(name = "level")
	protected int level;
	@XmlElement(name = "spawn")
	protected List<Spawn> spawns;

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @return the spawn
	 */
	public List<Spawn> getSpawns() {
		return spawns;
	}
}