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
package com.aionemu.gameserver.questEngine.handlers.models.xmlQuest.events;

import com.aionemu.gameserver.questEngine.handlers.models.xmlQuest.conditions.QuestConditions;
import com.aionemu.gameserver.questEngine.handlers.models.xmlQuest.operations.QuestOperations;
import com.aionemu.gameserver.questEngine.model.QuestEnv;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr. Poke
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestEvent", propOrder = { "conditions", "operations" })
@XmlSeeAlso({ OnKillEvent.class, OnTalkEvent.class })
public abstract class QuestEvent {

	protected QuestConditions conditions;
	protected QuestOperations operations;
	@XmlAttribute
	protected List<Integer> ids;

	public boolean operate(QuestEnv env) {
		return false;
	}

	/**
	 * Gets the value of the ids property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the ids property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getIds().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Integer }
	 */
	public List<Integer> getIds() {
		if (ids == null) {
			ids = new ArrayList<Integer>();
		}
		return this.ids;
	}
}