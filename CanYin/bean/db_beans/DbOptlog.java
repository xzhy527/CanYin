package db_beans;
import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Table;

/**
 * Model class of db_optlog.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
@Table("db_optlog")
public class DbOptlog implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** ID. */
	private Integer id;

	/** Type. */
	private String type;

	/** Name. */
	private String name;

	/** Descr. */
	private String descr;

	/** CreateTime. */
	private Date createtime;

	/** TableID. */
	private Integer tableid=0;

	/** InWay. */
	private String inway;

	/** Operator. */
	private String operator;

	/**
	 * Constructor.
	 */
	public DbOptlog() {
		
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
	 * Set the CreateTime.
	 * 
	 * @param createtime
	 *            CreateTime
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * Get the CreateTime.
	 * 
	 * @return CreateTime
	 */
	public Date getCreatetime() {
		return this.createtime;
	}

	/**
	 * Set the TableID.
	 * 
	 * @param tableid
	 *            TableID
	 */
	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}

	/**
	 * Get the TableID.
	 * 
	 * @return TableID
	 */
	public Integer getTableid() {
		return this.tableid;
	}

	/**
	 * Set the InWay.
	 * 
	 * @param inway
	 *            InWay
	 */
	public void setInway(String inway) {
		this.inway = inway;
	}

	/**
	 * Get the InWay.
	 * 
	 * @return InWay
	 */
	public String getInway() {
		return this.inway;
	}

	/**
	 * Set the Operator.
	 * 
	 * @param operator
	 *            Operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * Get the Operator.
	 * 
	 * @return Operator
	 */
	public String getOperator() {
		return this.operator;
	}


}
