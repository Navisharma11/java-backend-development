package com.navi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class AnswerTable 
{
	@Id
	@Column(name="answer_id")
	private Integer id;
	
	private String answer;


	@ManyToOne(cascade=CascadeType.ALL)
	private QuestionTable questionTable;
	
	public AnswerTable()
	{
		System.out.println("Zero Param Constructor of Answer");
	}
	
	



	public QuestionTable getQuestionTable() {
		return questionTable;
	}





	public void setQuestionTable(QuestionTable questionTable) {
		this.questionTable = questionTable;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}



	@Override
	public String toString() {
	    // We only print the database ID of the question to break the cycle!
	    return "AnswerTable [id=" + id + ", answer=" + answer + ", questionId=" + (questionTable != null ? questionTable.getId() : "null") + "]";
	}


	
	
	
}
