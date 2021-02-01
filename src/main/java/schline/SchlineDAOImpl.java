package schline;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public interface SchlineDAOImpl {

	//시험타입으로 문제리스트 가져오기
	public ArrayList<ExamDTO> examlist(int exam_case);
	
	//타입으로 과제 가져오기
	public ArrayList<ExamDTO> tasklist(int exam_case);
	
	//객관식문제의 문항 가져오기
	public ArrayList<ExamDTO> questionlist();
	
	//자동점수채점을 위해..문제리스트 가져오기
	public ArrayList<ExamDTO> scoringList();
}
