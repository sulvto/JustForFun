package me.qinchao.pss.query;

import org.apache.commons.lang3.StringUtils;

public class DepartmentQuery extends BaseQuery {
	private String name;

	public DepartmentQuery() {
		super("Department");
	}

	@Override
	public void addWhere() {
		if (StringUtils.isNotBlank(name)) {
			addWhere(" o.name like ? ", "%" + name + "%");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "DepartmentQuery [name=" + name  + "]";
	}

}
