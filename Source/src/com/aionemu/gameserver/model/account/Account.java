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
package com.aionemu.gameserver.model.account;

import com.aionemu.gameserver.model.Race;
import com.aionemu.gameserver.model.items.storage.Storage;

import java.sql.Timestamp;
import java.util.*;

/**
 * This class represents game account and is holding such informations as:
 * <ul>
 * <li>account id</li>
 * <li>account name</li>
 * <li> {@link AccountTime account time info}</li>
 * <li>a list of {@link PlayerAccountData} objects each of which keeping information about player that must be available
 * on character selection screen.</li>
 * </ul>
 * 
 * @author SoulKeeper
 * @modified cura
 */
public class Account implements Iterable<PlayerAccountData> {

	/** Unique id of this account (it's generated by login server) */
	private final int id;
	/** Unique name of this account */
	private String name;
	/**
	 * Access level
	 */
	private byte accessLevel;
	/**
	 * Membership of this account
	 */
	private byte membership;

	private AccountTime accountTime;

	private Map<Integer, PlayerAccountData> players = new HashMap<Integer, PlayerAccountData>();

	private Storage accountWarehouse;

	private int numberOfAsmos = 0;

	private int numberOfElyos = 0;

	private CharacterPasskey characterPasskey;

	private String securityToken = "";

	private long tollCount;
	private long lunaCount;

	public Account(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountTime getAccountTime() {
		return accountTime;
	}

	public void setAccountTime(AccountTime accountTime) {
		this.accountTime = accountTime;
	}

	/**
	 * @return the accessLevel
	 */
	public byte getAccessLevel() {
		return accessLevel;
	}

	/**
	 * @param accessLevel
	 *          the accessLevel to set
	 */
	public void setAccessLevel(byte accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * @return the membership
	 */
	public byte getMembership() {
		return membership;
	}

	/**
	 * @param membership
	 *          the membership to set
	 */
	public void setMembership(byte membership) {
		this.membership = membership;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Account)) {
			return false;
		}
		Account account = (Account) o;

		return id == account.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	/**
	 * @param chaOid
	 * @return PlayerAccountData
	 */
	public PlayerAccountData getPlayerAccountData(int chaOid) {
		return players.get(chaOid);
	}

	/**
	 * @param accPlData
	 */
	public void addPlayerAccountData(PlayerAccountData accPlData) {
		players.put(accPlData.getPlayerCommonData().getPlayerObjId(), accPlData);
		switch (accPlData.getPlayerCommonData().getRace()) {
			case ASMODIANS:
				numberOfAsmos++;
				break;
			case ELYOS:
				numberOfElyos++;
			break;
		}
	}

	/**
	 * @return the accountWarehouse
	 */
	public Storage getAccountWarehouse() {
		return accountWarehouse;
	}

	/**
	 * @param accountWarehouse
	 *          the accountWarehouse to set
	 */
	public void setAccountWarehouse(Storage accountWarehouse) {
		this.accountWarehouse = accountWarehouse;
	}

	/**
	 * @return the characterPasskey
	 */
	public CharacterPasskey getCharacterPasskey() {
		if (characterPasskey == null) {
			characterPasskey = new CharacterPasskey();
		}
		return characterPasskey;
	}

	/** Returns the number of players that are on this account */
	public int size() {
		return players.size();
	}

	/**
	 * Sorts the accounts on last online.
	 */
	public ArrayList<PlayerAccountData> getSortedAccountsList() {
		ArrayList<PlayerAccountData> list = new ArrayList<PlayerAccountData>();
		list.addAll(players.values());
		Collections.sort(list, new Comparator<PlayerAccountData>() {

			@Override
			public int compare(PlayerAccountData x, PlayerAccountData y) {
				Timestamp t1 = x.getPlayerCommonData().getLastOnline();
				Timestamp t2 = y.getPlayerCommonData().getLastOnline();
				if (t2 == null) {
					return 1;
				}
				else if (t1 == null) {
					return -1;
				}
				return y.getPlayerCommonData().getLastOnline().compareTo(x.getPlayerCommonData().getLastOnline());
			}
		});
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<PlayerAccountData> iterator() {
		return players.values().iterator();
	}

	public int getNumberOf(Race race) {
		switch (race) {
			case ASMODIANS:
				return numberOfAsmos;
			case ELYOS:
				return numberOfElyos;
		}
		return 0;
	}

	public void decrementCountOf(Race race) {
		switch (race) {
			case ASMODIANS:
				numberOfAsmos--;
				break;
			case ELYOS:
				numberOfElyos--;
				break;
		}
	}

	public void setToll(long toll) {
		tollCount = toll;
	}

	public long getToll() {
		return tollCount;
	}
	
	public void setLuna(long luna) {
		lunaCount = luna;
	}

	public long getLuna() {
		return lunaCount;
	}

	public boolean isEmpty() {
		return numberOfAsmos == 0 && numberOfElyos == 0;
	}

	public int getMaxPlayerLevel() {
		int maxLevel = 1;
		for (PlayerAccountData pad : players.values()) {
			if (pad.getPlayerCommonData().getLevel() > maxLevel) {
				maxLevel = pad.getPlayerCommonData().getLevel();
			}
		}
		return maxLevel;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String token) {
		this.securityToken = token;
	}
}