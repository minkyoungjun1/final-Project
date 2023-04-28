package kr.or.movie.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.or.movie.model.dao.MovieDao;
import kr.or.movie.model.vo.Movie;
import kr.or.movie.model.vo.MovieFile;
import kr.or.movie.model.vo.MoviePost;
import kr.or.movie.model.vo.MoviePostComment;
import kr.or.movie.model.vo.MovieVideo;
import kr.or.movie.model.vo.Review;
import kr.or.movie.model.vo.ReviewPageData;
import kr.or.movie.model.vo.ReviewWatch;
import kr.or.movie.model.vo.WatchPoint;

@Service
public class MovieService {
	@Autowired
	private MovieDao dao;

public ArrayList<Movie> selectMovieAll() {
		//영화 전체조회
		ArrayList<Movie> list =dao.selectMovieAll();
		for(Movie movie : list) {
			int movieNum= movie.getMovieNo();
			MovieFile movieFile = dao.selectMovieFile(movieNum);
			movie.setMainFile(movieFile);
			Review movieScoreAvg=dao.onlyWatchPointAvg(movieNum);
			movie.setMovieScoreAvg(movieScoreAvg);
		}
		
		return list;
		
	}
	//상영예정작 조회
	public ArrayList<Movie> expectedMovie() {
		ArrayList<Movie> expectedList =dao.expectedMovie();
		for(Movie movie : expectedList) {
			int movieNum= movie.getMovieNo();
			MovieFile movieFile = dao.selectMovieFile(movieNum);
			movie.setMainFile(movieFile);
			Review movieScoreAvg=dao.onlyWatchPointAvg(movieNum);
			movie.setMovieScoreAvg(movieScoreAvg);

		}
		
		return expectedList;
	}
	//특별상영작 조회
	public ArrayList<Movie> specialMovie() {
		ArrayList<Movie> specialMovieList =dao.specialMovie();
		for(Movie movie : specialMovieList) {
			int movieNum= movie.getMovieNo();
			MovieFile movieFile = dao.selectMovieFile(movieNum);
			movie.setMainFile(movieFile);
			Review movieScoreAvg=dao.onlyWatchPointAvg(movieNum);
			movie.setMovieScoreAvg(movieScoreAvg);
			
		}	
		
		return specialMovieList;
	}
	//필름소사이어티 조회
	public ArrayList<Movie> filmSocietyList() {
		ArrayList<Movie> filmSocietyList =dao.filmSocietyList();
		for(Movie movie : filmSocietyList) {
			int movieNum= movie.getMovieNo();
			MovieFile movieFile = dao.selectMovieFile(movieNum);
			movie.setMainFile(movieFile);
			Review movieScoreAvg=dao.onlyWatchPointAvg(movieNum);
			movie.setMovieScoreAvg(movieScoreAvg);
			
		}	
		
		return filmSocietyList;
	}
	//클래식소사이어티조회
	public ArrayList<Movie> classicSocietyList() {
		ArrayList<Movie> classicSocietyList =dao.classicSocietyList();
		for(Movie movie : classicSocietyList) {
			int movieNum= movie.getMovieNo();
			MovieFile movieFile = dao.selectMovieFile(movieNum);
			movie.setMainFile(movieFile);
			Review movieScoreAvg=dao.onlyWatchPointAvg(movieNum);
			movie.setMovieScoreAvg(movieScoreAvg);
			
		}	
		
		return classicSocietyList;
	}
	
	

	public Movie selectOneMovie(int movieNo) {
		Movie mov = dao.selectOneMovie(movieNo);
		 if(mov !=null) {
			 MovieFile movieFile = dao.selectMovieFile(movieNo);
			 mov.setMainFile(movieFile);
		 }
		return mov;
	}
	public ArrayList<MovieVideo> selectOneMovieVideo(int movieNo) {
		ArrayList<MovieVideo> mv= dao.selectOneMovieVideo(movieNo);	
		return mv;
	}
	//영화 리뷰 인서트
	public int reviewInsert(Review rev, WatchPoint wPoint) {
		int result = dao.reviewInsert(rev);
		if(result>0) {
			wPoint.setReviewCommentNo(rev.getReviewCommentNo());
			result += dao.watchPointInsert(wPoint);
		}
		return result;
	}
	//관람평 업데이트(=리뷰 업데이트)
		public int reviewUpdate(Review rev) {
			int result = dao.reviewUpdate(rev);
			System.out.println(result);
			return result;
		}
		public int watchPointUpdate(WatchPoint wPoint) {
			int result = dao.watchPointUpdate(wPoint);
			System.out.println(result);
			return result;
		}
		
		
	public Review getReview(String memberId) {
		// TODO Auto-generated method stub
		return dao.getReview(memberId);
	}
	
	//한 영화의 관람평 리스트를 모두 조회함
	public ArrayList<Review> oneMovieAllReview(int movieNo) {
		ArrayList<Review> reviewList = dao.oneMovieAllReview(movieNo);
		return reviewList;
	}
	//watchPoint를 위한 조회
	public Review onlyWatchPointAvg(int movieNo) {
		Review wpList=dao.onlyWatchPointAvg(movieNo);
		return wpList;
	}
	//watchPointSum(관람포인트별 합계 조회)
	public WatchPoint watchPointSum(int movieNo) {
		WatchPoint wpSum=dao.watchPointSum(movieNo);
		return wpSum;
	}
	public int selectReviewListCount(int movieNo) {
		int reviewListCount = dao.selectReviewListCount(movieNo);
		return reviewListCount;
	}
	public ArrayList<MovieFile> selectMovieFileAll(int movieNo) {
		ArrayList<MovieFile> movieFileAll=dao.selectMovieFileAll(movieNo);
		return movieFileAll;
	}
	//리뷰삭제하기
	public int deleteReview(int reviewCommentNo) {
		return dao.deleteReview(reviewCommentNo);
	}
	//관람포인트 삭제하기
	public int deleteWatchPoint(int reviewCommentNo) {
		return dao.deleteWatchPoint(reviewCommentNo);
	}
	public ReviewPageData selectReviewList(int movieNo,int reqPage) {
		//처음에 페이지당 보여줄 게시물의 수는 10개로 함
		int numPerPage = 10;
		//reqPage=1인경우 1번 10번 2인경우 11번 20번까지
		int end = reqPage*numPerPage;
		int start = end-numPerPage+1;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end",end);
		map.put("movieNo",movieNo);
		ArrayList<Review> list = dao.selectReviewList(map);
		System.out.println(map);
		
		//pageNavi제작시작
		//먼저 전체 페이지 수 계산하기->전체 게시물 수 조회
		int totalCount = dao.selectReviewCount(movieNo);
		System.out.println(totalCount+"전체게시물 수");
		//전체 게시물로 전체 페이지 수 계산
		
		int totalPage=(int)Math.ceil(totalCount/(double)numPerPage);
		//페이지 네비사이즈
		int pageNaviSize=5;
		
		int pageNo = 1;
		if(reqPage>3) {
			pageNo=reqPage-2;
		}
		
		//페이지너비 생성
		String pageNavi="";
		//이전버튼 생성
		if(reqPage != 1) {
			pageNavi += "<a href='/movieDetail.do?movieNo="+movieNo+"&reqPage="+(pageNo-1)+"&stat=1'>[이전]</a>";
		}
		//페이지 숫자 생성
		for(int i =0; i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi+="<span>"+pageNo+"</span>";
			}else {
				pageNavi +="<a href='/movieDetail.do?movieNo="+movieNo+"&reqPage="+pageNo+"&stat=1'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;//더이상 페이지 번호를 만들지 않음
				
			}
		}
		//다음버튼 생성
		if(pageNo<=totalPage) {
			pageNavi += "<a href='/movieDetail.do?movieNo="+movieNo+"&reqPage="+pageNo+"&stat=1'>[다음]</a>";
		}
		ReviewPageData rpd= new ReviewPageData(list,pageNavi);
		return rpd;
	}
	public int postInsert(MoviePost post) {
		int result = dao.postInsert(post);
		return result;
	}
	public int selectMovieListCount() {
		return dao.totalMovieCount();
	}
	public ArrayList<MoviePost> oneMovieAllPost(int movieNo) {
		ArrayList<MoviePost> postAllList=dao.selectOneMovieAllPost(movieNo);
		
		
		return postAllList;
	}
	public MoviePost selectDetailPost(int moviePostNo) {
		MoviePost moviePostOne=dao.selectDetailPost(moviePostNo);
		
		if(moviePostOne != null) {
			ArrayList<MoviePostComment> mpc= dao.selectPostComment(moviePostNo);
			moviePostOne.setMoviePostComment(mpc);
		}
		 return moviePostOne; 
	}
	public int insertPostComment(MoviePostComment mpc) {
		int result = dao.insertPostComment(mpc);
		return result;
	}


	public int updatePostComment(MoviePostComment mpc) {
		int result = dao.updatePostComment(mpc);
		return result;
	}
	public int moviePostCount(int movieNo) {
		int moviePostCount = dao.selectMoviePostCount(movieNo);
		return moviePostCount;
	}
	public int deletePostComment(int moviePostCommentNo) {
		int deletePostComment=dao.deletePostComment(moviePostCommentNo);
		return deletePostComment;
	}
	public MoviePost selectOneMoviePost(int moviePostNo) {
		MoviePost moviePost=dao.selectOneMoviePost(moviePostNo);
		System.out.println(moviePost);
		return moviePost;
	}
	public int postUpdate(MoviePost moviePost) {
		int result = dao.postUpdate(moviePost);
		return result;
	}
	public int postDelete(MoviePost moviePost) {
		int result = dao.postDelete(moviePost);
		return result;
	}






	

}
