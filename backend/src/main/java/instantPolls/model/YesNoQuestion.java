package instantPolls.model;

import java.util.ArrayList;

public class YesNoQuestion implements Question {
	
	private int id;
	private String question;
	private ArrayList<Answer> listOfAnswers;
	
	
	public YesNoQuestion(String question) {
		this.question = question;
		this.listOfAnswers = new ArrayList<>();
		this.listOfAnswers.add(new Answer("Tak"));
		this.listOfAnswers.add(new Answer("Nie"));
	}
	
	public void addAnswer(String answer, int question_id, String user_id) {
		for(Answer a : listOfAnswers) {
			if(a.getUsersVoted().contains(user_id)) {
				a.getUsersVoted().remove(user_id);
			}
			if(a.getAnswer().equals(answer)) {
				if(!a.getUsersVoted().contains(user_id)) {
					a.getUsersVoted().add(user_id);
				} 
			}
			
		}
	}
	
	public ArrayList<Integer> getNumberOfVotes() {
		ArrayList<Integer> votes = new ArrayList<>();
		for(Answer a : listOfAnswers) {
			votes.add(a.getUsersVoted().size());
		}
		return votes;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public ArrayList<String> getOptions() {
		ArrayList<String> answers = new ArrayList<>();
		for(Answer a: listOfAnswers) {
			answers.add(a.getAnswer());
		}
		return answers;
	}
	
	public ArrayList<Answer> getAnswers() {
		return listOfAnswers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.listOfAnswers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}