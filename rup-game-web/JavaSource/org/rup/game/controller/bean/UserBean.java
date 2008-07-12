package org.rup.game.controller.bean;


/**
 * @author KLM63827
 */
public class UserBean extends ViewBean {

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the surname.
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname The surname to set.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	private String name;
	private String surname;
}
