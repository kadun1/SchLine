package kosmo.project3.schline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import schline.ExamDTO;
import schline.SchlineDAOImpl;

@Controller
public class ExamController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/class/examStart.do")
	public String examStart(Model model, HttpServletRequest req) {
		
		//시험시작 전 필요한 파라미터를 생각해봅시다..
		
		return "/classRoom/exam/examStart";
	}

	@RequestMapping("/class/examList.do")
	public String examList(Model model, HttpServletRequest req) {
		/*
		타입이 시험일때...추후 파라미터로 변경
		학생 및 과목 정보가 필요할듯
		*/
		int exam_type = 2;
		
		//문제 리스트를 가져오기 위해 매퍼를통한 쿼리문 실행
		ArrayList<ExamDTO> examlist = 
				sqlSession.getMapper(SchlineDAOImpl.class).examlist(exam_type);
		//쿼리문 확인
		String sql = sqlSession.getConfiguration()
				.getMappedStatement("examlist")
					.getBoundSql(exam_type).getSql();
		System.out.println(sql);
		
		//객관식 타입 문제의 문항을 가져오기 위한 리스트 선언
		ArrayList<ExamDTO> questionlist = null;
		String temp;
		//문제리스트 반복..(차후 줄바꿈에 대한 처리 추가 필요)
		for(ExamDTO dto : examlist) {
			
			//문제 줄바꿈처리
			temp = dto.getQuestion_content().replace("\r\n", "<br/>");
			dto.setQuestion_content(temp);
			
			//문제의 유형이 객관식이라면...
			if(dto.getQuestion_type()==1) {
				//매퍼에 설정된 쿼리를 통해 문항을 가져온다.
				questionlist = 
					sqlSession.getMapper(SchlineDAOImpl.class).questionlist();
				for(ExamDTO listdto : questionlist) {
					System.out.println(listdto.getQuestionlist_content());
					//문항 줄바꿈처리
					temp = listdto.getQuestionlist_content().replace("\r\n", "<br/>");
					listdto.setQuestionlist_content(temp);
				}
			}
		}
		
		//뷰에서 사용하기 위해 모델 객체에 저장
		model.addAttribute("questionlist", questionlist);
		model.addAttribute("examlist", examlist);
		
		//뷰로 이동
		return "/classRoom/exam/examList";
	}
	
	@RequestMapping(value="/class/examComplete.do", method = RequestMethod.POST)
	public String examComplete(Model model, HttpServletRequest req) {

		/*
			과목 및 학생별로 판단하기 위해 파라미터처리가 필요..
		*/
		
		//학생이 입력한 정답의 값을 배열로 가져옴
		String[] choice = req.getParameterValues("choice");
		//랜덤으로 출력했던 각 문제의 인덱스를 배열로 가져옴
		String[] questionNum = req.getParameterValues("questionNum");
		
		//점수합산을 위해 쿼리를 통해 문제리스트를 가져옴
		ArrayList<ExamDTO> scoringList = sqlSession.getMapper(SchlineDAOImpl.class).scoringList();
		
		//점수
		int score = 0;
		
		for(ExamDTO dto : scoringList) {
				
			//문제의인덱스(총문제)의 크기만큼 반복(디버깅이 좀 필요해 보입니다... 헷갈림)
			for(int i = 0; i<questionNum.length; i++) {
			
				//리스트의 문제인덱스와 반복중인 문제의 인덱스가 같으면..
				if(Integer.parseInt(questionNum[i])==(dto.getQuestion_idx())){
					
					System.out.println("가져온인덱스 : "+ dto.getQuestion_idx()+"/시험문제인덱스 : "+questionNum[i]);
					System.out.println("가져온정답 : "+ dto.getAnswer()+"/학생선택 : "+choice[i]);
					System.out.println("가져온문제의타입(1객/2단/3주) : "+ dto.getQuestion_type());
					System.out.println("가져온문제의배점 : "+dto.getQuestion_score()+"점");
					
					//문제타입이 주관식이 아니라면...!
					if(dto.getQuestion_type()!=3) {
						//정답이라면...
						if(dto.getAnswer().equalsIgnoreCase(choice[i])) {
							System.out.println((i+1)+"번 문제 정답");
							//점수 더하기
							score += dto.getQuestion_score();
						}
						//오답이면....
						else {
							System.out.println((i+1)+"번 문제 오답");
						}
					}
					//주관식일 경우...(추가처리 필요)
					else {
						System.out.println("========위 문제는 주관식입니다..=========");
					}
				}
				System.out.println();
			}
		}
		model.addAttribute("score", score);
		return "/classRoom/exam/examScore";
	}
	
	@RequestMapping("/class/taskList.do")
	public String taskList(Model model, HttpServletRequest req) {
		
		//타입이 과제일때..
		int exam_type = 1;
		
		ArrayList<ExamDTO> examlist = 
				sqlSession.getMapper(SchlineDAOImpl.class).tasklist(exam_type);
		//쿼리문 확인
		String sql = sqlSession.getConfiguration()
				.getMappedStatement("tasklist")
					.getBoundSql(exam_type).getSql();
		System.out.println(sql);
		
		//객관식 타입 문제의 문항을 가져오기 위한 리스트 선언
		ArrayList<ExamDTO> questionlist = null;
		
		//문제리스트 반복..(차후 줄바꿈에 대한 처리 추가 필요)
		for(ExamDTO dto : examlist) {
			
			//줄바꿈처리
			String temp = dto.getExam_content().replace("\r\n", "<br/>");
			dto.setExam_content(temp);
		}
		
		//뷰에서 사용하기 위해 모델 객체에 저장
		model.addAttribute("questionlist", questionlist);
		model.addAttribute("examlist", examlist);
		
		//뷰로 이동
		return "/classRoom/exam/examList";
		
	}
}
