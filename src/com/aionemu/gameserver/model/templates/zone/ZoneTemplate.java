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
package com.aionemu.gameserver.model.templates.zone;

import com.aionemu.gameserver.world.zone.ZoneName;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author ATracer
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "Zone")
public class ZoneTemplate {

	@XmlElement
	protected Points points;

	@XmlElement
	protected Cylinder cylinder;

	@XmlElement
	protected Sphere sphere;

	@XmlElement
	protected Semisphere semisphere;

	@XmlAttribute
	protected int flags = -1;

	@XmlAttribute
	protected int priority;

	@XmlTransient
	private String name;

	@XmlTransient
	private ZoneName zoneName;

	@XmlAttribute(name = "name")
	public String getXmlName() {
		return name;
	}

	protected void setXmlName(String name) {
		zoneName = ZoneName.createOrGet(name);
		this.name = zoneName.name();
	}

	@XmlAttribute
	protected int mapid;

	@XmlAttribute(name = "siege_id")
	protected List<Integer> siegeId;

	@XmlAttribute(name = "town_id")
	private int townId;

	@XmlAttribute(name = "area_type")
	protected AreaType areaType = AreaType.POLYGON;

	@XmlAttribute(name = "zone_type")
	protected ZoneClassName zoneType = ZoneClassName.SUB;

	/**
	 * Gets the value of the points property.
	 */
	public Points getPoints() {
		return points;
	}

	public Cylinder getCylinder() {
		return cylinder;
	}

	public Sphere getSphere() {
		return sphere;
	}

	public Semisphere getSemisphere() {
		return semisphere;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Gets the value of the name property.
	 */
	public ZoneName getName() {
		return zoneName;
	}

	/**
	 * Gets the value of the mapid property.
	 */
	public int getMapid() {
		return mapid;
	}

	/**
	 * @return the type
	 */
	public AreaType getAreaType() {
		return areaType;
	}

	/**
	 * @return the zoneType
	 */
	public ZoneClassName getZoneType() {
		return zoneType;
	}

	public List<Integer> getSiegeId() {
		return siegeId;
	}

	public int getFlags() {
		return flags;
	}

	public int getTownId() {
		return townId;
	}
}