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
package com.aionemu.gameserver.model.templates.spawns.vortexspawns;

import com.aionemu.gameserver.model.templates.spawns.Spawn;
import com.aionemu.gameserver.model.vortex.VortexStateType;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VortexSpawn")
public class VortexSpawn
{
	@XmlAttribute(name = "id")
	private int id;
	
	public int getId() {
		return id;
	}
	
	@XmlElement(name = "state_type")
	private List<VortexSpawn.VortexStateTemplate> VortexStateTemplate;
	
	public List<VortexStateTemplate> getSiegeModTemplates() {
		return VortexStateTemplate;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "VortexStateTemplate")
	public static class VortexStateTemplate {
	
		@XmlElement(name = "spawn")
		private List<Spawn> spawns;
		
		@XmlAttribute(name = "state")
		private VortexStateType stateType;
		
		public List<Spawn> getSpawns() {
			return spawns;
		}
		
		public VortexStateType getStateType() {
			return stateType;
		}
	}
}