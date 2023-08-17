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
package com.aionemu.gameserver.model.templates.spawns.landingspecialspawns;

import com.aionemu.gameserver.model.landing_special.LandingSpecialStateType;
import com.aionemu.gameserver.model.templates.spawns.Spawn;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LandingSpecialSpawn")
public class LandingSpecialSpawn
{
    @XmlAttribute(name = "id")
    private int id;
	
    public int getId() {
        return id;
    }
	
    @XmlElement(name = "landing_special_type")
    private List<LandingSpecialSpawn.LandingSpStateTemplate> LandingSpStateTemplate;
	
    public List<LandingSpStateTemplate> getSiegeModTemplates() {
        return LandingSpStateTemplate;
    }
	
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "LandingSpStateTemplate")
    public static class LandingSpStateTemplate {
		
        @XmlElement(name = "spawn")
        private List<Spawn> spawns;
		
        @XmlAttribute(name = "fstate")
        private LandingSpecialStateType landingSpecialType;
		
        public List<Spawn> getSpawns() {
            return spawns;
        }
		
        public LandingSpecialStateType getLandingSpecialType() {
            return landingSpecialType;
        }
    }
}