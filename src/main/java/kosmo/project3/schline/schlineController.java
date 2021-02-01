package kosmo.project3.schline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class schlineController {
////////////////테스트 컨트롤러 삭제예정///////////////////////
	
	//스터디룸 이동
	@RequestMapping("/class/studyRoom.do")
	public String studyRoomGo () {
		
		return "studyRoom";
		
	}
}
