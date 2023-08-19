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
package com.aionemu.gameserver.model.templates;

import com.aionemu.gameserver.model.templates.expand.Expand;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Simple
 */
@XmlRootElement(name = "cube_npc")
@XmlAccessorType(XmlAccessType.FIELD)
public class CubeExpandTemplate {

	@XmlElement(name = "expand", required = true)
	protected List<Expand> cubeExpands;

	@XmlAttribute(name = "id", required = true)
	private int Id;

	public int getNpcId() {
		return Id;
	}

	public boolean contains(int level) {
		for (Expand expand : cubeExpands) {
			if (expand.getLevel() == level) {
				return true;
			}
		}
		return false;
	}

	public Expand get(int level) {
		for (Expand expand : cubeExpands) {
			if (expand.getLevel() == level) {
				return expand;
			}
		}
		return null;
	}
}