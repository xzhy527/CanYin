package db_beans;
import java.io.Serializable;

/**
 * Model class of db_Config.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class DbConfig implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** ID. */
	private Integer id;

	/** Type. */
	private String type;

	/** Name. */
	private String name;

	/** CharValue. */
	private String charvalue;

	/** IntValue. */
	private Integer intvalue;

	/** Descr. */
	private String descr;

	/** Reserved. */
	private String reserved;

	/**
	 * Constructor.
	 */
	public DbConfig() {
	}

	/**
	 * Set the ID.
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the ID.
	 * 
	 * @return ID
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set the Type.
	 * 
	 * @param type
	 *            Type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the Type.
	 * 
	 * @return Type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Set the Name.
	 * 
	 * @param name
	 *            Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Name.
	 * 
	 * @return Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the CharValue.
	 * 
	 * @param charvalue
	 *            CharValue
	 */
	public void setCharvalue(String charvalue) {
		this.charvalue = charvalue;
	}

	/**
	 * Get the CharValue.
	 * 
	 * @return CharValue
	 */
	public String getCharvalue() {
		return this.charvalue;
	}

	/**
	 * Set the IntValue.
	 * 
	 * @param intvalue
	 *            IntValue
	 */
	public void setIntvalue(Integer intvalue) {
		this.intvalue = intvalue;
	}

	/**
	 * Get the IntValue.
	 * 
	 * @return IntValue
	 */
	public Integer getIntvalue() {
		return this.intvalue;
	}

	/**
	 * Set the Descr.
	 * 
	 * @param descr
	 *            Descr
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * Get the Descr.
	 * 
	 * @return Descr
	 */
	public String getDescr() {
		return this.descr;
	}

	/**
	 * Set the Reserved.
	 * 
	 * @param reserved
	 *            Reserved
	 */
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	/**
	 * Get the Reserved.
	 * 
	 * @return Reserved
	 */
	public String getReserved() {
		return this.reserved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DbConfig other = (DbConfig) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}