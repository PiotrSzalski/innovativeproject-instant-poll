package instantPolls.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleAnswerQuestion implements Question {
	private int id;
	private String question;
	private ArrayList<Answer> listOfAnswers;
	private String type;
	private boolean active;
	private boolean hiddenResults;
	
	public SingleAnswerQuestion(String question, List<String> answers) {
		this.question = question;
		this.listOfAnswers = new ArrayList<>();
		this.type = "optionsSingle";
		answers.forEach( answerText -> {
			Answer answer = new Answer(answerText);
			this.listOfAnswers.add(answer);
		});
		this.active = true;
		this.hiddenResults = false;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void addAnswer(List<Integer> answer, int question_id, String user_id) {
		listOfAnswers.forEach( a -> {
			if(a.getUsersVoted().contains(user_id)) {
				a.getUsersVoted().remove(user_id);
			}
		});
		listOfAnswers.get(answer.get(0)).getUsersVoted().add(user_id);	
	}

	@Override
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public ArrayList<String> getOptions() {
		ArrayList<String> answers = new ArrayList<>();
		for(Answer a: listOfAnswers) {
			answers.add(a.getAnswer());
		}
		return answers;
	}

	@Override
	public ArrayList<Answer> getAnswers() {
		return listOfAnswers;
	}
	
	public void setAnswers(ArrayList<Answer> answers) {
		this.listOfAnswers = answers;
	}

	@Override
	public ArrayList<Integer> getNumberOfVotes() {
		ArrayList<Integer> votes = new ArrayList<>();
		if(hiddenResults) {
			votes = new ArrayList<Integer>(Collections.nCopies(listOfAnswers.size(), 0));
			int numberOfVoters = 0;
			for(Answer a : listOfAnswers)
				numberOfVoters += a.getUsersVoted().size();
			votes.set(0, numberOfVoters);
		}
		else 
			for(Answer a : listOfAnswers)
				votes.add(a.getUsersVoted().size());
		
		return votes;
	}
	
	@Override
	public int getTotalVotes() {
		int numberOfVoters = 0;
		for(Answer a : listOfAnswers)
			numberOfVoters += a.getUsersVoted().size();
		return numberOfVoters;
	}

	@Override
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isHiddenResults() {
		return hiddenResults;
	}

	public void setHiddenResults(boolean hiddenResults) {
		this.hiddenResults = hiddenResults;
	}
}
