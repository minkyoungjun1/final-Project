<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<link rel="stylesheet" href="/resources/css/member/deleteFrm.css">
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/menubar.jsp" />

<style>
	.menu{
		float: left;
	}
</style>

<form action="/deleteMember.do" method="post">
	<div class="wrapper">
        <div class="mypage-wrap">
            <div class="mypage-header">
                <h2>회원탈퇴</h2>
                <ul class="info">
                    <li>[주의]회원님의 정보를 정확히 입력해주세요.</li>
                </ul>
                <p>1. 탈퇴 후 삭제 내역</p>
                <p>(회원 탈퇴하시면 회원정보와 개인 보유 보인트 등 정보가 삭제되며 데이터는 복구되지 않습니다.)</p>
                <ul>
                	<li>메가박스 멤버십 포인트 및 적립/차감 내역</li>
                	<li>관람권 및 쿠폰</li>
                	<li>영화 관람 내역</li>
                	<li>간편 로그인 연동 정보</li>
                </ul>
                <p>2. 고객님께서 불편하셨던 점, 아쉬웠던 점을 알려주시면 앞으로 더 나은 모습으로 찾아 뵙겠습니다.</p>
                <input type="radio" name="trouble" id="figure">
                	<label for="figure">서비스 장애가 잦아서</label><br>
                <input type="radio" name="trouble" id="figure2">
                	<label for="figure2">이벤트 및 무료서비스 혜택이 적어서</label><br>
                <input type="radio" name="trouble" id="figure3">
                	<label for="figure3">불만 및 불편사항에 대한 고객응대가 나빠서</label><br>
                <input type="radio" name="trouble" id="figure4">
                	<label for="figure4">영화관람시 시설 및 가격등의 불만 때문에</label><br>
                <input type="radio" name="trouble" id="figure5">
                	<label for="figure5">탈퇴 후 재가입을 위해</label><br>             	                	                	                	                
                <input type="radio" name="trouble" id="figure6">
                	<label for="figure6">휴면계정 만료</label>
                <p>3. 회원님의 비밀번호를 입력하시고 [탈퇴] 버튼을 클릭해주세요.</p>
                <table>
                	<tr>
                		<th>아이디</th>
                		<td>
                			<input type="text" name="memberId">
                		</td>
                	</tr>
                	<tr>
                		<th>비밀번호</th>
                		<td>
                			<input type="password" name="memberPw">
                		</td>
                	</tr>
                </table>
            </div>
            
            <div class="btn-wrap">
                <button type="button" id="cancelBtn">취소</button>
                <input type="submit" value="탈퇴" id="enrollBtn"></input>
            </div>
        </div>
   </div>
</form>
    
   <script src="/resources/js/member/myProfile.js"></script>
   <jsp:include page="/WEB-INF/views/common/footer.jsp" />