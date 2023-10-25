
package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	
	
	//---- quiz01 ----
	// 즐겨찾기 추가 화면
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 추가 로직 - AJAX가 하는 요청
	@ResponseBody
	@PostMapping("/quiz01/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name")String name,
			@RequestParam("url")String url) {
		//DBinsert
		bookmarkBO.addBookmark(name, url);
		//응답값 -> jason(map으로구성하면서) String
		Map<String, Object> result = new HashMap<>();
		result.put("code",200);
		result.put("result","success");
		return result;// jason string으로 내려간다
		
	}
	// 즐겨찾기 목록 화면
	@GetMapping("/quiz01/bookmark-list-view")
	public String bookmarkListView(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();// 즐겨찾기의 모든 행을 가지고 온다
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/bookmarkList";
	}
	
	//-----quiz01 끝----
	
//	//-----quiz02-----
//	// URL 중복확인 - AJAX 요청
	/**
	 * @param url
	 * @return
	 */
	@ResponseBody
	@PostMapping("/quiz02/is-duplicated-url")
	public Map<String, Object> isDuplicatedUrl(
			@RequestParam("url")String url){
		
		//DB조회
		Bookmark bookmark = bookmarkBO.getBookmarkByUrl(url);
		//응답값
		Map<String, Object>result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", false); // 기본값으로 설정
		
		if (bookmark != null) {
			result.put("is_duplication", true);
		}
		return result;
		
	}
	
	// bookmark 삭제 기능 -AJAX 호출
		@ResponseBody
		@GetMapping("/quiz02/delete-bookmark")
		public Map<String, Object> deleteBookmark(
				@RequestParam("id") int id) {
			
			// db delete
			bookmarkBO.deleteBookmarkById(id);
			
			Map<String, Object> result = new HashMap<>();
			result.put("code", 200);
			result.put("result", "성공");
			return result;  // json
	}



		
	
}




	
