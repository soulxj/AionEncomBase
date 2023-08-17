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
package com.aionemu.gameserver.model.templates.item;

import com.aionemu.gameserver.model.PlayerClass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanke on 01/03/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ItemSkillEnhance")
public class ItemSkillEnhance
{
    @XmlAttribute(name="id")
    protected int id;
	
    @XmlAttribute(name="skill_id")
    protected List<Integer> skillId;
	
    @XmlAttribute(name="player_class")
    private PlayerClass classId = PlayerClass.ALL;
	
    public int getId() {
        return this.id;
    }
	
    public List<Integer> getSkillId() {
        if (skillId == null) {
            skillId = new ArrayList<Integer>();
        }
        return skillId;
    }
	
    public PlayerClass getClassId() {
        return classId;
    }
}