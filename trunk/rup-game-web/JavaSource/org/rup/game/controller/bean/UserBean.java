package org.rup.game.controller.bean;


/**
 * @author KLM63827
 */
public class UserBean extends ViewBean {

	public class QuizActivity {
		private long tsStarted;
		private String subjectName;
		private String skillLevelName;
		/**
		 * 
		 * @param tsStarted
		 * @param subjectName
		 */
		public QuizActivity(long tsStarted, final String subjectName, final String skillLevelName) {
			this.tsStarted = tsStarted;
			this.subjectName = subjectName;
			this.skillLevelName = skillLevelName;
		}
		/**
		 * @return Returns the subjectName.
		 */
		public String getSubjectName() {
			return subjectName;
		}
		/**
		 * @return Returns the tsStarted.
		 */
		public long getTsStarted() {
			return tsStarted;
		}
		/**
		 * @return
		 */
		public String getSkillLevelName() {
			return skillLevelName;
		}
	}
	
	private String name;
	private String surname;
	private QuizActivity currentQuiz;
	
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
	
	/**
	 * @return Returns the currentQuiz.
	 */
	public QuizActivity getCurrentQuiz() {
		return currentQuiz;
	}
	
	/**
	 * @return Returns the currentQuiz.
	 */
	public void startQuiz(long tsBegin, final String subjectName, final String skillLevelName) {
		this.currentQuiz = new QuizActivity(tsBegin, subjectName, skillLevelName);
	}
	
	/**
	 *
	 */
	public void closeCurrentQuiz() {
		this.currentQuiz = null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return name + " " +  surname;
	}
}
