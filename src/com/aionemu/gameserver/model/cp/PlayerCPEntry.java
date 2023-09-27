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
package com.aionemu.gameserver.model.cp;

import com.aionemu.gameserver.model.gameobjects.PersistentState;

public class PlayerCPEntry extends CPEntry {

	private PersistentState persistentState;

	public PlayerCPEntry(int slot, int point, PersistentState persistentState) {
		super(slot, point);
		this.persistentState = persistentState;
	}

	public PersistentState getPersistentState() {
		return persistentState;
	}

	public void setPersistentState(PersistentState persistentState) {
		switch (persistentState) {
			case DELETED:
				if (this.persistentState == PersistentState.NEW) {
					this.persistentState = PersistentState.NOACTION;
				}
				else {
					this.persistentState = PersistentState.DELETED;
				}
				break;
			case UPDATE_REQUIRED:
				if (this.persistentState != PersistentState.NEW) {
					this.persistentState = PersistentState.UPDATE_REQUIRED;
				}
				break;
			case NOACTION:
				break;
			default:
				this.persistentState = persistentState;
		}
	}
}